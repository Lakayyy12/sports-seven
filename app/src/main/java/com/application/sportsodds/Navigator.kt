package com.application.sportsodds

import android.content.Context
import android.content.Intent

class Navigator {

    companion object {
        fun openPage(context: Context, className: Class<*>) {
            val intent = Intent(context, className)
            context.startActivity(intent)
        }

        fun openPage(context: Context, className: Class<*>, image: Int, position: Int) {
            val intent = Intent(context, className)
            intent.putExtra("image", image)
            intent.putExtra("content", position)
            context.startActivity(intent)
        }
    }
}