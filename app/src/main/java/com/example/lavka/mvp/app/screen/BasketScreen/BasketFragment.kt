package com.example.lavka.mvp.app.screen.BasketScreen

import android.content.Intent
import android.os.Bundle

import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lavka.R
import com.example.lavka.mvp.Contract
import com.example.lavka.mvp.Helper.OrderStaticHelper
import com.example.lavka.mvp.model.ProductCartModel
import com.example.lavka.mvp.presenter.Presenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BasketFragment : Fragment(R.layout.fragment_basket), Contract.view {
    var BasketItemRecyclerView: RecyclerView? = null
    var BasketLinerL: LinearLayoutManager? = null
    var BasketArrayList: ArrayList<ProductCartModel> = OrderStaticHelper.arrayList
    lateinit var basketFragmentAdapter: BasketFragmentAdapter


    val mPresenter: Presenter = Presenter(this)

    val s = 12
    companion object {
        lateinit var byButton: Button
         fun RxLoadBasketArray(): Observable<ArrayList<ProductCartModel>> {
            return Observable.create { subscriber ->


                subscriber.onNext(OrderStaticHelper.arrayList)
            }


        }
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        additemRecuclerView()

        byButton = view?.findViewById(R.id.buyButton)



        if (OrderStaticHelper.price == 0) {
            byButton = view?.findViewById(R.id.buyButton)
            byButton.text = "Пока нету товаров"
            OrderStaticHelper.price = 0
        }
        byButton.setOnClickListener {
            mPresenter.onClickByButton()


            val  kkk = 12
            val dd = 131




            val pa = 333

        }


    }






    override fun onStop() {
        super.onStop()
        OrderStaticHelper.price -= OrderStaticHelper.price


    }


    fun additemRecuclerView() {
        BasketItemRecyclerView = view?.findViewById(R.id.BasketRecyclerView)
        BasketLinerL = LinearLayoutManager(context)




        val rxLoadBasketRecyclerView = RxLoadBasketArray().subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread()).subscribe (
                {
                    BasketItemRecyclerView?.layoutManager = BasketLinerL
                    basketFragmentAdapter = BasketFragmentAdapter(it, requireContext())
                    BasketItemRecyclerView!!.adapter = basketFragmentAdapter

                },{

                },{

                })




    }

    override fun onStartButtomSheetFragment() {
        super.onStartButtomSheetFragment()

        if (OrderStaticHelper.price!=0)
        findNavController().navigate(R.id.action_basketFragment_to_buttomSheetFragment2)
//        var buttomSheetFragment : ButtomSheetFragment = ButtomSheetFragment()
//        buttomSheetFragment.show(parentFragmentManager,buttomSheetFragment.tag)

    }
}