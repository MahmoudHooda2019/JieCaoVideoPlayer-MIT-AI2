package fm.jiecao.jcvideoplayer_lib.layout;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import fm.jiecao.jcvideoplayer_lib.values.drawables;

public class jc_dialog_brightness extends LinearLayout {

    public TextView tvBrightness;
    public ProgressBar brightnessProgressBar;

    public jc_dialog_brightness(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        setOrientation(VERTICAL);
        setBackground(drawables.jc_dialog_progress_bg(context));

        LinearLayout innerLayout = new LinearLayout(context);
        LayoutParams innerParams = new LayoutParams(dpToPx(155), dpToPx(120));
        innerLayout.setLayoutParams(innerParams);
        innerLayout.setOrientation(VERTICAL);

        ImageView brightnessIcon = new ImageView(context);
        LayoutParams iconParams = new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        iconParams.topMargin = dpToPx(20);
        iconParams.gravity = Gravity.CENTER_HORIZONTAL;
        brightnessIcon.setLayoutParams(iconParams);
        brightnessIcon.setImageDrawable(drawables.fromBase64(context, drawables.jc_brightness_video_png));

        tvBrightness = new TextView(context);
        tvBrightness.setId(ViewGroup.generateViewId());
        tvBrightness.setTag("tv_brightness");
        LayoutParams textParams = new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        textParams.topMargin = dpToPx(12);
        textParams.gravity = Gravity.CENTER_HORIZONTAL;
        tvBrightness.setLayoutParams(textParams);
        tvBrightness.setTextColor(Color.WHITE);
        tvBrightness.setTextSize(16);
        tvBrightness.setGravity(Gravity.CENTER_HORIZONTAL);

        brightnessProgressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        brightnessProgressBar.setId(ViewGroup.generateViewId());
        brightnessProgressBar.setTag("brightness_progressbar");
        LayoutParams barParams = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dpToPx(3));
        barParams.leftMargin = dpToPx(24);
        barParams.rightMargin = dpToPx(24);
        barParams.topMargin = dpToPx(8);
        barParams.bottomMargin = dpToPx(20);
        barParams.gravity = Gravity.CENTER_HORIZONTAL;
        brightnessProgressBar.setLayoutParams(barParams);
        brightnessProgressBar.setMax(100);
        brightnessProgressBar.setProgressDrawable(drawables.jc_dialog_progress(context));

        innerLayout.addView(brightnessIcon);
        innerLayout.addView(tvBrightness);
        innerLayout.addView(brightnessProgressBar);

        this.addView(innerLayout);
    }

    private int dpToPx(float dp) {
        return (int) (dp * getResources().getDisplayMetrics().density + 0.5f);
    }

}
