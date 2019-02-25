package com.yoesuv.myespresso.utils.bindings

import android.databinding.BindingAdapter
import android.support.v7.widget.AppCompatEditText
import android.text.TextWatcher
import com.yoesuv.myespresso.R

class Converters {

    companion object {

        @BindingAdapter("text")
        @JvmStatic fun bindEditText(view: AppCompatEditText, bindableString: BindableString){
            val pair = view.getTag(R.id.bound_observable) as Pair<BindableString, MyTextWatcherAdapter?>?
            if (pair == null || pair.first != BindableString()){
                if (pair != null) {
                    view.removeTextChangedListener(pair.second as TextWatcher)
                }
                val watcher = object: MyTextWatcherAdapter(){
                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        super.onTextChanged(s, start, before, count)
                        bindableString.set(s?.toString())
                    }
                }
                view.setTag(R.id.bound_observable, Pair<BindableString, MyTextWatcherAdapter>(bindableString, watcher))
                view.addTextChangedListener(watcher)
            }
            val newValue = bindableString.get()
            if (view.text?.toString() != newValue) {
                view.setText(newValue)
            }

        }

    }

}