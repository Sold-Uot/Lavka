package com.example.lavka.mvp.app.screen.BasketScreen


import android.annotation.SuppressLint
import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lavka.R
import com.example.lavka.mvp.Helper.OrderStaticHelper
import com.example.lavka.mvp.model.ProductCartModel
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BasketFragmentAdapter(var list: ArrayList<ProductCartModel>, var context: Context) :
    RecyclerView.Adapter<BasketFragmentAdapter.BasketItemViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketItemViewHolder {


        return BasketItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.basket_item, parent, false)
        )
    }


    @SuppressLint("CheckResult", "SetTextI18n")
    override fun onBindViewHolder(holder: BasketItemViewHolder, position: Int) {
        var price = list?.get(position)?.price
        var name = list?.get(position)?.name

        holder.name.text = name
        holder.price.text = price.toString() + "₽"
        Picasso.with(context).load(list.get(position).imgres).into(holder.imageview)

        var col = 1

        var id = 0
        id += 1


        OrderStaticHelper.price += price!!
        BasketFragment.byButton.text = OrderStaticHelper.price.toString()!! + " ₽"


        holder.appKolButton.setOnClickListener(View.OnClickListener {

            onRxKolButton(col).observeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe {
                col += 1
                holder.kol.text = col.toString()
                OrderStaticHelper.price += price!!

                BasketFragment.byButton.text = OrderStaticHelper.price.toString() + " ₽"
                    BasketFragment.byButton.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        34f)
                holder.kol.text = col.toString()
            }


        })

        holder.downKolButton.setOnClickListener(View.OnClickListener {
            onRxKolButton(col).observeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                if (col != 1) {
                    col -= 1
                    OrderStaticHelper.price -= price
                    BasketFragment.byButton.text = OrderStaticHelper.price.toString() + " ₽"
                    BasketFragment.byButton.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        34f)




                }
                holder.kol.text = col.toString()
            }

        })

        holder.deletButton.setOnClickListener(View.OnClickListener {

            list = OrderStaticHelper.arrayList
            list.removeAt(position)
            notifyItemRemoved(position)
            OrderStaticHelper.price -= col * price
            BasketFragment.byButton.text = OrderStaticHelper.price.toString() + " ₽"

        })




    }

    fun onRxKolButton(int: Int): Observable<Int> {
        return Observable.create { sub ->
            sub.onNext(int)
        }
    }


    override fun getItemCount(): Int {

        return list!!.size
    }

    class BasketItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.nameBasket)
        var price: TextView = itemView.findViewById(R.id.priceBasket)
        var imageview: ImageView = itemView.findViewById(R.id.imageViewBasket)
        var downKolButton: Button = itemView.findViewById(R.id.downkol)
        var appKolButton: Button = itemView.findViewById(R.id.appkol)
        var kol: TextView = itemView.findViewById(R.id.kolBasket)
        var deletButton: Button = itemView.findViewById(R.id.button3)


    }


}
