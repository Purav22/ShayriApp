package com.example.allshayri2021;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainAdapter extends BaseAdapter {
    SecondActivity second_page;
    String[] title;
    Animation ani;
    Integer[] images;

    public MainAdapter(SecondActivity second_page, String[] title, Integer[] images)  {
        this.second_page = second_page;
        this.title = title;
        this.images = images;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        View v = view;
//        ViewHolder viewHolder = null;
//
//        if(v == null) {
//            LayoutInflater layoutInflater = second_page.getLayoutInflater();
//            v = layoutInflater.inflate(R.layout.layout_for_images_logo,null,true);
//            viewHolder = new ViewHolder(v);
//            v.setTag(viewHolder);
//        }else {
//            viewHolder = (ViewHolder) v.getTag();
//        }
        ani = AnimationUtils.loadAnimation(second_page, R.anim.animation1);
//        viewHolder.text.setText(title[i]);
//        viewHolder.img.setImageResource(images[i]);
//
//        viewHolder.text.setAnimation(ani);
//        viewHolder.img.setAnimation(ani);
        view = LayoutInflater.from(second_page).inflate(R.layout.view, viewGroup, false);

        TextView textView;
        ImageView image;
        image = view.findViewById(R.id.imageView1);
        textView = view.findViewById(R.id.textview);
        textView.setText(title[i]);
        image.setImageResource(images[i]);
        textView.setAnimation(ani);
        image.setAnimation(ani);
//        Toast.makeText(second_page.getApplicationContext(), "first ", Toast.LENGTH_SHORT).show();

        return view;
    }


}