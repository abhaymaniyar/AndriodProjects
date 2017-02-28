package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by abhay on 27/11/16.
 */

public class WordAdapter extends ArrayAdapter<Word>{

    private int mColorResourceId;
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

//        listItemView.setBackgroundColor();


        // Get the {@link Word} object located at this position in the list
        Word currentNumber = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.miwok_word);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentNumber.getMiwokWord());
        Log.v("Miwok word : ", currentNumber.getMiwokWord());
        //Find the ImageView in the list_item.xml layout with the ID
        ImageView img = (ImageView) listItemView.findViewById(R.id.item_image);
        if(currentNumber.hasImage()){
            img.setImageResource(currentNumber.getmImageResourceId());
            img.setVisibility(View.VISIBLE);
        }else{
            img.setVisibility(View.GONE);
        }

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.eng_word);
        // Get the version number from the current AndroidFlavor object and
        numberTextView.setText(currentNumber.getEnglishWord());


        View textContainer = listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        textContainer.setBackgroundColor(color);
        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
//        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
//        iconView.setImageResource(currentAndroidFlavor.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }


    public WordAdapter(Context context, ArrayList<Word> arrayList, int colorResourceId){
        super(context, 0, arrayList);
        mColorResourceId = colorResourceId;
    }

}
