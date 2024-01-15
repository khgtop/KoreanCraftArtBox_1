package com.example.koreancraftartbox

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide


object CustomToast {
    private var toast: Toast? = null
//    private var layout: View? = null
    fun showToast(context: Context, message: String, layoutId: Int) {
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(layoutId, null)

        val toastTextView = layout.findViewById<TextView>(R.id.toast_textview)
        val toastImageView = layout.findViewById<ImageView>(R.id.toast_arrow_gif)
        toastTextView.text = message
        Glide.with(context).load(R.raw.toast_arrow).into(toastImageView!!)

        cancelToast()
        toast = Toast(context)
        toast?.duration = Toast.LENGTH_LONG
        toast?.view = layout
        toast?.setGravity(Gravity.BOTTOM, 0, 0)
        toast?.show()

    }
    fun cancelToast() {
        val view = toast?.view
        view?.animation?.cancel()
        view?.visibility = View.GONE
        toast?.cancel()
        toast = null
    }
}