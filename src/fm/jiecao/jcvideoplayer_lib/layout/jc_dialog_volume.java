package fm.jiecao.jcvideoplayer_lib.layout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import fm.jiecao.jcvideoplayer_lib.values.drawables;

public class jc_dialog_volume extends LinearLayout {

    public ImageView volumeImageTip;
    public TextView tvVolume;
    public ProgressBar volumeProgressBar;

    public jc_dialog_volume(Context context) {
        super(context);
        setOrientation(VERTICAL);
        setLayoutParams(new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        setBackground(drawables.jc_dialog_progress_bg(context));

        // Inner container layout
        LinearLayout container = new LinearLayout(context);
        container.setOrientation(VERTICAL);
        LayoutParams containerParams = new LayoutParams(
                dpToPx(155),
                dpToPx(120)
        );
        container.setLayoutParams(containerParams);

        // ImageView: volume_image_tip
        volumeImageTip = new ImageView(context);
        volumeImageTip.setId(View.generateViewId());
        volumeImageTip.setTag("volume_image_tip");
        LinearLayout.LayoutParams imageParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
        imageParams.topMargin = dpToPx(20);
        imageParams.gravity = Gravity.CENTER_HORIZONTAL;
        volumeImageTip.setLayoutParams(imageParams);

        // TextView: tv_volume
        tvVolume = new TextView(context);
        tvVolume.setId(View.generateViewId());
        tvVolume.setTag("tv_volume");
        LinearLayout.LayoutParams textParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
        textParams.topMargin = dpToPx(12);
        textParams.gravity = Gravity.CENTER_HORIZONTAL;
        tvVolume.setLayoutParams(textParams);
        tvVolume.setTextColor(Color.WHITE);
        tvVolume.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        tvVolume.setGravity(Gravity.CENTER_HORIZONTAL);

        // ProgressBar: volume_progressbar
        volumeProgressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        volumeProgressBar.setId(View.generateViewId());
        volumeProgressBar.setTag("volume_progressbar");
        LinearLayout.LayoutParams progressParams = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dpToPx(3)
        );
        progressParams.gravity = Gravity.CENTER_HORIZONTAL;
        progressParams.setMargins(dpToPx(24), dpToPx(8), dpToPx(24), dpToPx(20));
        volumeProgressBar.setLayoutParams(progressParams);
        volumeProgressBar.setMax(100);
        volumeProgressBar.setProgressDrawable(drawables.jc_dialog_progress(context));

        // Add children
        container.addView(volumeImageTip);
        container.addView(tvVolume);
        container.addView(volumeProgressBar);

        addView(container);
    }

    private int dpToPx(float dp) {
        return (int) (dp * getResources().getDisplayMetrics().density + 0.5f);
    }

}
