package com.example.mvpfood.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("menu_harga")
	val menuHarga: String? = null,

	@field:SerializedName("menu_gambar")
	val menuGambar: String? = null,

	@field:SerializedName("menu_nama")
	val menuNama: String? = null,

	@field:SerializedName("menu_id")
	val menuId: String? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(menuHarga)
		parcel.writeString(menuGambar)
		parcel.writeString(menuNama)
		parcel.writeString(menuId)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<DataItem> {
		override fun createFromParcel(parcel: Parcel): DataItem {
			return DataItem(parcel)
		}

		override fun newArray(size: Int): Array<DataItem?> {
			return arrayOfNulls(size)
		}
	}
}