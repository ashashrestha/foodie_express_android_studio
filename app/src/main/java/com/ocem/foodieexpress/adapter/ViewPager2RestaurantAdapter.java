package com.ocem.foodieexpress.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ocem.foodieexpress.fragment.ColdBeverageFragment;
import com.ocem.foodieexpress.fragment.MomoFragment;
import com.ocem.foodieexpress.fragment.PastaFragment;
import com.ocem.foodieexpress.fragment.PizzaFragment;

public class ViewPager2RestaurantAdapter extends FragmentStateAdapter {
    public ViewPager2RestaurantAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0){
            return new PizzaFragment();
        } else if (position==1) {
            return new MomoFragment();
        } else if (position==2) {
            return new ColdBeverageFragment();
        }else {
            return new PastaFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
