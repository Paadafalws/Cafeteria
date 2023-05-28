package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CatalogAdapter extends ArrayAdapter<String> {

    private List<String> itemList;
    private LayoutInflater inflater;

    public CatalogAdapter(Context context, List<String> itemList) {
        super(context, 0, itemList);
        this.itemList = itemList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_catalog, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.itemNameTextView = convertView.findViewById(R.id.itemTextView);
            viewHolder.itemPriceTextView = convertView.findViewById(R.id.textViewPrice);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String item = itemList.get(position);

        viewHolder.itemNameTextView.setText(item);


        return convertView;
    }

    private static class ViewHolder {
        TextView itemNameTextView;
        TextView itemPriceTextView;
    }
}
