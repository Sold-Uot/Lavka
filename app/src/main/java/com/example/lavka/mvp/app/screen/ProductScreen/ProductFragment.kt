package com.example.lavka.mvp.app.screen.ProductScreen

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import com.example.lavka.R
import com.example.lavka.mvp.Contract
import com.example.lavka.mvp.Helper.OrderStaticHelper
import com.example.lavka.mvp.app.screen.BasketScreen.BasketFragment
import com.example.lavka.mvp.model.ImageTypeModel
import com.example.lavka.mvp.model.ProductCartModel
import com.example.lavka.mvp.presenter.Presenter
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class ProductFragment : Fragment(), Contract.view {
    private lateinit var mPresenter: Presenter


    private lateinit var dbref: DatabaseReference
    private var progressBar : ProgressBar?=null
    private var RecyclerViewProduct: RecyclerView? = null
    private var linearLayoutManagerProduct: LinearLayoutManager? = null
    private var recyclerView: RecyclerView? = null
    private var typeAdapter: ImageTypeAdapter? = null
    private var productsList: ArrayList<ImageTypeModel>? = null
    private var linearLayoutManager: LinearLayoutManager? = null
    private lateinit var pRef : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mPresenter = Presenter(this)
        val с =1
        return inflater.inflate(R.layout.fragment_product, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mPresenter.addItemRecyclerView(context,view)



        GlobalScope.launch {
            mPresenter.setRecyclerFirebase(context,view,null)}




    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        pRef = context.getSharedPreferences("basketArray",MODE_PRIVATE)

    }


    override fun showFirebaseRecyclerView(c: Context?, view: View?,string: String?)  {
        super.showFirebaseRecyclerView(c, view,string)

       if (string ==null) {

           progressBar = view?.findViewById(R.id.progressBar)
           progressBar?.visibility = ProgressBar.VISIBLE
           RecyclerViewProduct = view?.findViewById(R.id.ProductCartRecycler)

           RecyclerViewProduct?.layoutManager =
               StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

           linearLayoutManagerProduct?.orientation = RecyclerView.VERTICAL
           dbref = FirebaseDatabase.getInstance().getReference("item")

           val FirebaseRecyclerOptions: FirebaseRecyclerOptions<ProductCartModel> =
               FirebaseRecyclerOptions.Builder<ProductCartModel>()
                   .setQuery(dbref, ProductCartModel::class.java).build()
           val fbAdapter = object :
               FirebaseRecyclerAdapter<ProductCartModel, ProductCardViewHolder>(
                   FirebaseRecyclerOptions
               ) {
               override fun onCreateViewHolder(
                   parent: ViewGroup,
                   viewType: Int
               ): ProductCardViewHolder {


                   var v: View = LayoutInflater.from(parent.context)
                       .inflate(R.layout.product_cart, parent, false)
                   return ProductCardViewHolder(v)
               }

               override fun onBindViewHolder(
                   holder: ProductCardViewHolder, position: Int, model: ProductCartModel
               ) {


                   var array: ArrayList<ProductCartModel> = ArrayList()
                   array.add(ProductCartModel(model.name))

                   holder.name.text = model.name
                   holder.price.text =
                       "${model.price.toString() + model.measurement_system.toString()} ₽"
                   Picasso.with(context).load(model.imgres).into(holder.imageview)




                   if (model.availability == false) {
                       holder.ability.text = "Нету в наличии"
                       holder.ability.setTextColor(Color.RED)
                   } else holder.ability.text = "Есть в наличии"



                   holder.checkBox.setOnClickListener {


                       val basketFragment : BasketFragment = BasketFragment()

                       if (model.availability == true) {
                           OrderStaticHelper.arrayList.add(
                               ProductCartModel(
                                   model.name,
                                   model.articul,
                                   model.availability,
                                   model.id,
                                   model.imgres,
                                   model.price,
                                   model.measurement_system

                               )
                           )


                       } else {
                           Toast.makeText(
                               context,
                               "К солжелению этот товар не достпуен",
                               Toast.LENGTH_LONG
                           ).show()
                           holder.checkBox.isChecked = false
                       }

                   }
                   progressBar?.visibility = ProgressBar.GONE

               }
           }


           fbAdapter.startListening()

           RecyclerViewProduct!!.adapter = fbAdapter

       }





    }
    fun rxlodder(array: ArrayList<ProductCartModel>): Observable<ArrayList<ProductCartModel>>? {


        return Observable.create {
            s -> s.onNext(array)
        }
    }

    override fun setRecycler(datalist: List<ImageTypeModel?>?, c: Context?, v: View?) {
        super.setRecycler(datalist, c, v)

        recyclerView = v?.findViewById(R.id.ImageViewTypeRecycler)
        linearLayoutManager = LinearLayoutManager(c)
        linearLayoutManager?.orientation = androidx.recyclerview.widget.RecyclerView.HORIZONTAL
        recyclerView?.layoutManager = linearLayoutManager
        typeAdapter = ImageTypeAdapter(datalist!!)
        recyclerView!!.adapter = typeAdapter


    }


    class ProductCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.nameProduct)
        var price: TextView = itemView.findViewById(R.id.price)
        var ability: TextView = itemView.findViewById(R.id.ability)
        var imageview: ImageView = itemView.findViewById(R.id.imageView)
        var checkBox: CheckBox = itemView.findViewById(R.id.checkBox2)


    }
}






