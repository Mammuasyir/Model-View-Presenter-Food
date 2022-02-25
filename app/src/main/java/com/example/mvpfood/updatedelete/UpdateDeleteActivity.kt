package com.example.mvpfood.updatedelete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.mvpfood.R
import com.example.mvpfood.model.DataItem
import kotlinx.android.synthetic.main.activity_update_delete.*

class UpdateDeleteActivity : AppCompatActivity() {

    var updateDeletePresenter : UpdateDeletePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_delete)


        updateDeletePresenter = UpdateDeletePresenter(this)

        // terima data dari adapter

        val reciveDataFood = intent.getParcelableExtra<DataItem>("Data")

        // tampilan data yang diterima

        Glide.with(this)
            .load(reciveDataFood?.menuGambar.toString())
            .error(R.drawable.ic_launcher_background)
            .into(img_update)

        edt_update_harga.setText(reciveDataFood?.menuHarga.toString())
        edt_update_nama.setText(reciveDataFood?.menuNama.toString())
        edt_update_url.setText(reciveDataFood?.menuGambar.toString())

        // update datanya
        btn_update.setOnClickListener {
            updateDeletePresenter?.updateFood(reciveDataFood?.menuId.toString(),
                edt_update_nama?.text.toString(),
                edt_update_harga?.text.toString(),
                edt_update_url?.text.toString())
        }

        // btn delete
btn_delete.setOnClickListener {
    updateDeletePresenter?.deleteFood(reciveDataFood?.menuId.toString())
}
    }

    fun showMessageUpdate(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun onSuccessUpdate() {
        finish()
    }

    fun showError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun showMessageDelete(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun onSuccessDelete() {
        finish()
    }
}