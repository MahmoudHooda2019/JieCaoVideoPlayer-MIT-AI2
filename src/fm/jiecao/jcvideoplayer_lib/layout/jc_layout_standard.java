package fm.jiecao.jcvideoplayer_lib.layout;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import fm.jiecao.jcvideoplayer_lib.values.drawables;

public class jc_layout_standard extends RelativeLayout {

    public jc_layout_standard(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        setBackgroundColor(Color.BLACK);
        setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);

        // Surface container
        FrameLayout surfaceContainer = new FrameLayout(context);
        surfaceContainer.setId(generateViewId());
        surfaceContainer.setTag("surface_container");
        surfaceContainer.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        addView(surfaceContainer);

        // Thumb image
        ImageView thumb = new ImageView(context);
        thumb.setId(generateViewId());
        thumb.setTag("thumb");
        LayoutParams thumbParams = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        thumbParams.addRule(ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        thumbParams.addRule(ALIGN_PARENT_END, RelativeLayout.TRUE);
        thumbParams.addRule(ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        thumbParams.addRule(ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        thumbParams.addRule(ALIGN_PARENT_START, RelativeLayout.TRUE);
        thumbParams.addRule(ALIGN_PARENT_END, RelativeLayout.TRUE);
        thumb.setLayoutParams(thumbParams);
        thumb.setScaleType(ImageView.ScaleType.FIT_CENTER);
        thumb.setBackgroundColor(Color.BLACK);
        addView(thumb);

        // Bottom control layout
        LinearLayout bottomLayout = new LinearLayout(context);
        bottomLayout.setId(generateViewId());
        bottomLayout.setTag("layout_bottom");
        LayoutParams bottomParams = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                dpToPx(50));
        bottomParams.addRule(ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        bottomLayout.setLayoutParams(bottomParams);
        bottomLayout.setGravity(Gravity.CENTER_VERTICAL);
        bottomLayout.setOrientation(LinearLayout.HORIZONTAL);
        bottomLayout.setVisibility(INVISIBLE);
        bottomLayout.setBackground(drawables.fromBase64(context, drawables.jc_bottom_bg_png));

        // current time
        TextView current = new TextView(context);
        current.setId(generateViewId());
        current.setTag("current");
        current.setText("00:00");
        current.setTextColor(Color.WHITE);
        LinearLayout.LayoutParams currentParams = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        currentParams.leftMargin = dpToPx(14);
        bottomLayout.addView(current, currentParams);

        // Seek bar
        SeekBar seekBar = new SeekBar(context);
        seekBar.setId(generateViewId());
        seekBar.setTag("bottom_seek_progress");
        LinearLayout.LayoutParams seekParams = new LinearLayout.LayoutParams(
                0,
                LayoutParams.WRAP_CONTENT);
        seekParams.weight = 1;
        seekParams.leftMargin = dpToPx(12);
        seekParams.rightMargin = dpToPx(12);
        seekBar.setLayoutParams(seekParams);
        seekBar.setMax(100);
        int paddingTopBottom = dpToPx(8);
        int paddingRightLeft = dpToPx(12);
        seekBar.setPadding(paddingRightLeft, paddingTopBottom, paddingRightLeft, paddingTopBottom);
        seekBar.setProgressDrawable(drawables.jc_bottom_seek_progress(context));
        seekBar.setThumb(drawables.jc_bottom_seek_thumb(context));
        seekBar.setBackground(null);
        seekBar.setMaxHeight(dpToPx(1));
        seekBar.setMinHeight(dpToPx(1));
        bottomLayout.addView(seekBar);

        // Total time
        TextView total = new TextView(context);
        total.setId(generateViewId());
        total.setTag("total");
        total.setText("00:00");
        total.setTextColor(Color.WHITE);
        bottomLayout.addView(total);

        // Clarity text
        TextView clarity = new TextView(context);
        clarity.setId(generateViewId());
        clarity.setTag("clarity");
        clarity.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        clarity.setText("clarity");
        clarity.setTextColor(Color.WHITE);
        clarity.setPadding(dpToPx( 20), 0, 0, 0);
        clarity.setClickable(true);
        clarity.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        bottomLayout.addView(clarity);

        // Fullscreen button
        ImageView fullscreen = new ImageView(context);
        fullscreen.setId(generateViewId());
        fullscreen.setTag("fullscreen");
        LinearLayout.LayoutParams fullscreenParams = new LinearLayout.LayoutParams(
                dpToPx(52.5f),
                LayoutParams.MATCH_PARENT);
        fullscreen.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        fullscreen.setPadding(dpToPx(14),0,dpToPx(14),0);
        fullscreen.setImageDrawable(drawables.fromBase64(context, drawables.jc_enlarge_png));
        fullscreen.setLayoutParams(fullscreenParams);
        bottomLayout.addView(fullscreen);

        addView(bottomLayout);

        // Progress bar
        ProgressBar progressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        progressBar.setId(generateViewId());
        progressBar.setTag("bottom_progress");
        LayoutParams progressParams = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                dpToPx(1.5f));
        progressParams.addRule(ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        progressBar.setLayoutParams(progressParams);
        progressBar.setMax(100);
        progressBar.setProgressDrawable(drawables.jc_bottom_progress(context));
        addView(progressBar);

        // Back Tiny Button
        ImageView backTiny = new ImageView(context);
        backTiny.setId(generateViewId());
        backTiny.setTag("back_tiny");
        RelativeLayout.LayoutParams backTinyParams = new RelativeLayout.LayoutParams(dpToPx(24), dpToPx(24));
        backTinyParams.leftMargin = dpToPx(6);
        backTinyParams.topMargin = dpToPx(6);
        backTiny.setLayoutParams(backTinyParams);
        backTiny.setBackground(drawables.jc_click_back_tiny_selector(context));
        backTiny.setVisibility(GONE);
        addView(backTiny);

        // Layout Top
        RelativeLayout layoutTop = new RelativeLayout(context);
        layoutTop.setId(generateViewId());
        layoutTop.setTag("layout_top");
        RelativeLayout.LayoutParams layoutTopParams = new RelativeLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                dpToPx(60)
        );
        layoutTopParams.addRule(ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        layoutTopParams.addRule(ALIGN_PARENT_START, RelativeLayout.TRUE);
        layoutTopParams.addRule(ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        layoutTop.setLayoutParams(layoutTopParams);
        layoutTop.setBackground(drawables.fromBase64(context, drawables.jc_title_bg_png));
        layoutTop.setGravity(Gravity.CENTER_VERTICAL);

        // Back Button
        ImageView back = new ImageView(context);
        back.setId(generateViewId());
        back.setTag("back");
        RelativeLayout.LayoutParams backParams = new RelativeLayout.LayoutParams(dpToPx(23), LayoutParams.MATCH_PARENT);
        backParams.addRule(ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        backParams.addRule(ALIGN_PARENT_START, RelativeLayout.TRUE);
        backParams.addRule(ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        back.setLayoutParams(backParams);
        back.setPadding(dpToPx(12), 0, 0, 0);
        back.setPaddingRelative(dpToPx(12), 0, 0, 0);
        back.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        back.setImageDrawable(drawables.jc_click_back_selector(context));
        layoutTop.addView(back);

        // Battery + Time Layout
        LinearLayout batteryTimeLayout = new LinearLayout(context);
        batteryTimeLayout.setId(generateViewId());
        batteryTimeLayout.setTag("battery_time_layout");
        RelativeLayout.LayoutParams batteryLayoutParams = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
        batteryLayoutParams.addRule(ALIGN_PARENT_END, RelativeLayout.TRUE);
        batteryLayoutParams.addRule(ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        batteryLayoutParams.addRule(CENTER_VERTICAL, RelativeLayout.TRUE);
        batteryLayoutParams.setMarginEnd(dpToPx(14));
        batteryLayoutParams.setMargins(0 ,0, dpToPx(14), 0);
        batteryTimeLayout.setLayoutParams(batteryLayoutParams);
        batteryTimeLayout.setGravity(Gravity.CENTER_VERTICAL);
        batteryTimeLayout.setOrientation(LinearLayout.VERTICAL);

        ImageView batteryLevel = new ImageView(context);
        batteryLevel.setId(generateViewId());
        batteryLevel.setTag("battery_level");
        LinearLayout.LayoutParams batteryParams = new LinearLayout.LayoutParams(dpToPx(23), dpToPx(10));
        batteryParams.gravity = CENTER_HORIZONTAL;
        batteryLevel.setLayoutParams(batteryParams);
        batteryLevel.setBackground(drawables.fromBase64(context, drawables.jc_battery_level_10_png));
        batteryTimeLayout.addView(batteryLevel);

        TextView videoCurrentTime = new TextView(context);
        videoCurrentTime.setId(generateViewId());
        videoCurrentTime.setTag("video_current_time");
        LinearLayout.LayoutParams vctParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        vctParams.gravity = CENTER_HORIZONTAL;
        videoCurrentTime.setLayoutParams(vctParams);
        videoCurrentTime.setGravity(Gravity.CENTER_VERTICAL);
        videoCurrentTime.setMaxLines(1);
        videoCurrentTime.setTextColor(Color.WHITE);
        videoCurrentTime.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12.0f);
        batteryTimeLayout.addView(videoCurrentTime);

        // Title
        TextView title = new TextView(context);
        title.setId(generateViewId());
        title.setTag("title");
        RelativeLayout.LayoutParams titleParams = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
        titleParams.addRule(CENTER_VERTICAL, RelativeLayout.TRUE);
        titleParams.addRule(END_OF, back.getId());
        titleParams.addRule(START_OF, batteryTimeLayout.getId());
        titleParams.addRule(RIGHT_OF, back.getId());
        titleParams.setMarginEnd(dpToPx(12));
        titleParams.setMarginStart(dpToPx(12));
        titleParams.setMargins(dpToPx(12), 0, dpToPx(12), 0);
        title.setLayoutParams(titleParams);
        title.setEllipsize(android.text.TextUtils.TruncateAt.END);
        title.setMaxLines(2);
        title.setTextColor(Color.WHITE);
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);

        layoutTop.addView(title);
        layoutTop.addView(batteryTimeLayout);

        addView(layoutTop);

        // Loading
        ProgressBar loading = new ProgressBar(context);
        loading.setId(generateViewId());
        loading.setTag("loading");
        RelativeLayout.LayoutParams loadingParams = new RelativeLayout.LayoutParams(dpToPx(45), dpToPx(45));
        loadingParams.addRule(CENTER_HORIZONTAL, RelativeLayout.TRUE);
        loadingParams.addRule(CENTER_VERTICAL, RelativeLayout.TRUE);
        loading.setLayoutParams(loadingParams);
        loading.setIndeterminateDrawable(drawables.jc_loading(context));
        loading.setVisibility(INVISIBLE);
        addView(loading);

        // Start Layout
        LinearLayout startLayout = new LinearLayout(context);
        startLayout.setId(generateViewId());
        startLayout.setTag("start_layout");
        RelativeLayout.LayoutParams startLayoutParams = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
        startLayoutParams.addRule(CENTER_HORIZONTAL, RelativeLayout.TRUE);
        startLayoutParams.addRule(CENTER_VERTICAL, RelativeLayout.TRUE);
        startLayout.setLayoutParams(startLayoutParams);

        ImageView start = new ImageView(context);
        start.setId(generateViewId());
        start.setTag("start");
        LinearLayout.LayoutParams startParams = new LinearLayout.LayoutParams(dpToPx(45), dpToPx(45));
        start.setLayoutParams(startParams);
        start.setImageDrawable(drawables.jc_click_play_selector(context));
        startLayout.addView(start);
        addView(startLayout);

        // Retry Text
        TextView retryText = new TextView(context);
        retryText.setId(generateViewId());
        retryText.setTag("retry_text");
        RelativeLayout.LayoutParams retryParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        retryParams.addRule(BELOW, startLayout.getId());
        retryParams.addRule(CENTER_HORIZONTAL);
        retryParams.topMargin = dpToPx(6);
        retryText.setLayoutParams(retryParams);
        retryText.setText("Replay");
        retryText.setTextColor(Color.WHITE);
        retryText.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
        retryText.setVisibility(INVISIBLE);
        addView(retryText);

    }

    private int dpToPx(float dp) {
        return (int) (dp * getResources().getDisplayMetrics().density + 0.5f);
    }
}
