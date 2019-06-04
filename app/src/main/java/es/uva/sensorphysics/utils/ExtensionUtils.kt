package es.uva.sensorphysics.utils

import android.view.LayoutInflater
import android.view.ViewGroup

fun ViewGroup.inflate(inflater: LayoutInflater = LayoutInflater.from(context), resource: Int) =
    inflater.inflate(resource, this, false)