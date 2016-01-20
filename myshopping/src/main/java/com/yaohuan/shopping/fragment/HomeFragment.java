package com.yaohuan.shopping.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.yaohuan.shopping.R;

/**
 * Created by yh on 2016/1/19.
 */
public class HomeFragment extends Fragment {
    private SliderLayout sliderShow;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, null);
        sliderShow = (SliderLayout)view.findViewById(R.id.slider);
        TextSliderView textSliderView = new TextSliderView(getContext());
        textSliderView
                .description("Game of Thrones")
                .image("http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);

        sliderShow.setCustomAnimation(new DescriptionAnimation());
        sliderShow.setPresetTransformer(SliderLayout.Transformer.RotateUp);
        sliderShow.setDuration(3000);

        sliderShow.addSlider(textSliderView);
        
        return view;
    }

    @Override
    public void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();
    }
}
