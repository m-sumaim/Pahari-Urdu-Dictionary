package com.sumaim.pahariDictionary.ui.main.fragment.more

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import com.sumaim.pahariDictionary.R
import com.sumaim.pahariDictionary.ui.main.fragment.home.onItemClick
import kotlinx.android.synthetic.main.fragment_more.*

/**
 * A simple [Fragment] subclass.
 */
class MoreFragment: Fragment(R.layout.fragment_more) {
    private lateinit var btnRateUs: onItemClick

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        textview_more_source_code.setOnClickListener {
            //openViaCustomTab()
            val uri: Uri = Uri.parse("market://details?id=com.")
            val goToMarket = Intent(Intent.ACTION_VIEW, uri)

            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK)

            try {
                startActivity(goToMarket)
            }catch (e: ActivityNotFoundException){
                startActivity(Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=com.")))
            }
        }

        textview_more_share_source_code.setOnClickListener {
            ShareCompat.IntentBuilder.from(requireActivity())
                .setType("text/plain")
                .setChooserTitle(R.string.text_share_via)
                .setText("https..")
                .startChooser()
        }

        textview_more_exit.setOnClickListener {
            requireActivity().finish()
        }

    }








//    fun openViaIntent(){
//        var intent = Intent(Intent.ACTION_VIEW)
//        intent.setData(Uri.parse("https://github.com/Muhammad-Javad/MVVM-persion-Dictionary"))
//        if(intent.resolveActivity(requireContext().packageManager) != null) {
//            startActivity(intent)
//        }else{
//            Toast.makeText(context, R.string.text_no_internet_explorer, Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    fun openViaCustomTab(){
//        var customTab = CustomTabsIntent.Builder()
//            .setToolbarColor(resources.getColor(R.color.colorPrimary))
//            .setShowTitle(true)
//            .build()
//        try {
//            customTab.launchUrl(requireContext(), Uri.parse("https://github.com/Muhammad-Javad/MVVM-persion-Dictionary"))
//        }catch (e: Exception){
//            openViaIntent()
//        }
//    }

}
