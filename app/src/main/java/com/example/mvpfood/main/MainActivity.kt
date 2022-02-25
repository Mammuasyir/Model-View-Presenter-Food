package com.example.mvpfood.main

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mvpfood.R
import com.example.mvpfood.model.DataItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mainPresenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)
        mainPresenter?.getAllFood()
    }

    fun showDataFood(dataFood: List<DataItem?>?) {
        val adapterFood = FoodAdapter(dataFood, this)
        rv_food.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            setHasFixedSize(true)
            adapter = adapterFood
        }
    }

    fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun showError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
    private fun onAttachView() {
        mainPresenter?.onAttach(this)
    }
    private fun onDetachView() {
        mainPresenter?.onDetach()
    }

    override fun onStart() {
        super.onStart()
        onAttachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        onDetachView()
    }

    override fun onResume() {
        super.onResume()
        mainPresenter?.getAllFood()
    }

    fun onSuccessInsert() {
        mainPresenter?.getAllFood()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_add -> {
                insertDialog()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun insertDialog() {
        val alert = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.dialog_insert, null)
        alert.setView(view)
        alert.setCancelable(false)
        alert.setTitle("Add New Menu")
        alert.setPositiveButton(
            "Save",
            DialogInterface.OnClickListener { dialogInterface, i ->
                val nameFood = view.findViewById<EditText>(R.id.edt_nama_makanan)
                val priceFood = view.findViewById<EditText>(R.id.edt_harga)
                val imgFood = view.findViewById<EditText>(R.id.edt_url_gambar)

                mainPresenter?.insertFood(
                    nameFood.text.toString(),
                    priceFood.text.toString(),
                    imgFood.text.toString()
                )
                dialogInterface.dismiss()
            })
        alert.setNeutralButton("close", DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.dismiss() })
        alert.show()
    }
}