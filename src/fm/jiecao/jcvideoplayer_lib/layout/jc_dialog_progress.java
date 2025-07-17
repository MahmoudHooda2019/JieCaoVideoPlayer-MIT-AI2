package fm.jiecao.jcvideoplayer_lib.layout;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import fm.jiecao.jcvideoplayer_lib.values.drawables;

public class jc_dialog_progress extends LinearLayout {

    public ImageView durationImageTip;
    public TextView tvCurrent;
    public TextView tvDuration;
    public ProgressBar durationProgressBar;

    public jc_dialog_progress(Context context) {
        super(context);

        setLayoutParams(new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        setOrientation(VERTICAL);
        setBackground(drawables.jc_dialog_progress_bg(context));

        LinearLayout innerLayout = new LinearLayout(context);
        LayoutParams innerParams = new LayoutParams(dpToPx(152), ViewGroup.LayoutParams.WRAP_CONTENT);
        innerLayout.setLayoutParams(innerParams);
        innerLayout.setOrientation(VERTICAL);

        durationImageTip = new ImageView(context);
        durationImageTip.setId(View.generateViewId());
        durationImageTip.setTag("duration_image_tip");
        LayoutParams imageParams = new LayoutParams(dpToPx(36), dpToPx(27));
        imageParams.topMargin = dpToPx(16);
        imageParams.gravity = Gravity.CENTER_HORIZONTAL;
        durationImageTip.setLayoutParams(imageParams);

        LinearLayout timeContainer = new LinearLayout(context);
        LayoutParams timeParams = new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        timeParams.topMargin = dpToPx(20);
        timeParams.gravity = Gravity.CENTER_HORIZONTAL;
        timeContainer.setLayoutParams(timeParams);
        timeContainer.setOrientation(HORIZONTAL);
        timeContainer.setGravity(Gravity.CENTER_HORIZONTAL);

        tvCurrent = new TextView(context);
        tvCurrent.setId(View.generateViewId());
        tvCurrent.setTag("tv_current");
        tvCurrent.setLayoutParams(new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        tvCurrent.setTextColor(Color.parseColor("#fff85959"));
        tvCurrent.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);

        tvDuration = new TextView(context);
        tvDuration.setId(View.generateViewId());
        tvDuration.setTag("tv_duration");
        tvDuration.setLayoutParams(new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        tvDuration.setTextColor(Color.WHITE);
        tvDuration.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);

        timeContainer.addView(tvCurrent);
        timeContainer.addView(tvDuration);

        durationProgressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        durationProgressBar.setId(View.generateViewId());
        durationProgressBar.setTag("duration_progressbar");
        LayoutParams progressParams = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dpToPx(4));
        progressParams.topMargin = dpToPx(8);
        progressParams.bottomMargin = dpToPx(16);
        progressParams.leftMargin = dpToPx(16);
        progressParams.rightMargin = dpToPx(16);
        progressParams.gravity = Gravity.CENTER_HORIZONTAL;
        durationProgressBar.setLayoutParams(progressParams);
        durationProgressBar.setMax(100);
        durationProgressBar.setProgressDrawable(drawables.jc_dialog_progress(context));

        innerLayout.addView(durationImageTip);
        innerLayout.addView(timeContainer);
        innerLayout.addView(durationProgressBar);

        this.addView(innerLayout);
    }

    private int dpToPx(float dp) {
        return (int) (dp * getResources().getDisplayMetrics().density + 0.5f);
    }

}
