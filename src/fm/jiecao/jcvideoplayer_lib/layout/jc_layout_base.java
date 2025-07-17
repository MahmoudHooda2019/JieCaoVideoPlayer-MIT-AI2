package fm.jiecao.jcvideoplayer_lib.layout;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

import fm.jiecao.jcvideoplayer_lib.values.drawables;

public class jc_layout_base extends RelativeLayout {

    public FrameLayout surfaceContainer;
    public LinearLayout layoutBottom;
    public LinearLayout layoutTop;
    public ProgressBar loading;
    public ImageView startButton;
    public TextView currentTime;
    public TextView totalTime;
    public SeekBar bottomSeekProgress;
    public ImageView fullscreenButton;

    public jc_layout_base(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT
        ));
        setBackgroundColor(Color.BLACK);

        // Surface container
        surfaceContainer = new FrameLayout(context);
        surfaceContainer.setId(View.generateViewId());
        surfaceContainer.setTag("surface_container");
        LayoutParams surfaceParams = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT
        );
        surfaceContainer.setLayoutParams(surfaceParams);
        addView(surfaceContainer);

        // Bottom layout
        layoutBottom = new LinearLayout(context);
        layoutBottom.setId(View.generateViewId());
        layoutBottom.setTag("layout_bottom");
        layoutBottom.setOrientation(LinearLayout.HORIZONTAL);
        layoutBottom.setGravity(Gravity.CENTER_VERTICAL);
        layoutBottom.setBackgroundColor(0x99000000);
        LayoutParams bottomParams = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                dpToPx(40)
        );
        bottomParams.addRule(ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        layoutBottom.setLayoutParams(bottomParams);
        addView(layoutBottom);

        // Current time
        currentTime = new TextView(context);
        currentTime.setId(View.generateViewId());
        bottomSeekProgress.setTag("current");
        currentTime.setText("00:00");
        currentTime.setTextColor(Color.WHITE);
        LinearLayout.LayoutParams currentTimeParams = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
        currentTimeParams.leftMargin = dpToPx(16);
        currentTime.setLayoutParams(currentTimeParams);
        layoutBottom.addView(currentTime);

        // SeekBar
        bottomSeekProgress = new SeekBar(context);
        bottomSeekProgress.setId(View.generateViewId());
        bottomSeekProgress.setTag("bottom_seek_progress");
        bottomSeekProgress.setMax(100);
        bottomSeekProgress.setPadding(0, dpToPx(8), 0, dpToPx(8));
        bottomSeekProgress.setProgressDrawable(drawables.jc_bottom_seek_progress(context));
        bottomSeekProgress.setThumb(drawables.jc_bottom_seek_thumb(context));
        LinearLayout.LayoutParams seekParams = new LinearLayout.LayoutParams(
                0,
                LayoutParams.WRAP_CONTENT,
                1.0f
        );
        seekParams.gravity = Gravity.CENTER_VERTICAL;
        bottomSeekProgress.setLayoutParams(seekParams);
        bottomSeekProgress.setBackground(null);
        bottomSeekProgress.setMaxHeight(dpToPx(4));
        bottomSeekProgress.setMinHeight(dpToPx(4));
        layoutBottom.addView(bottomSeekProgress);

        // Total time
        totalTime = new TextView(context);
        totalTime.setId(View.generateViewId());
        totalTime.setTag("total");
        totalTime.setText("00:00");
        totalTime.setTextColor(Color.WHITE);
        LinearLayout.LayoutParams totalParams = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
        totalParams.rightMargin = dpToPx(16);
        totalTime.setLayoutParams(totalParams);
        layoutBottom.addView(totalTime);

        // Fullscreen icon
        fullscreenButton = new ImageView(context);
        fullscreenButton.setId(View.generateViewId());
        fullscreenButton.setTag("fullscreen");
        fullscreenButton.setScaleType(ImageView.ScaleType.CENTER);
        fullscreenButton.setImageDrawable(drawables.fromBase64(context, drawables.jc_enlarge_png));
        LinearLayout.LayoutParams fullscreenParams = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT
        );
        fullscreenParams.rightMargin = dpToPx(16);
        fullscreenButton.setLayoutParams(fullscreenParams);
        layoutBottom.addView(fullscreenButton);

        // Top layout
        layoutTop = new LinearLayout(context);
        layoutTop.setId(View.generateViewId());
        layoutTop.setTag("layout_top");
        layoutTop.setOrientation(LinearLayout.HORIZONTAL);
        layoutTop.setGravity(Gravity.CENTER_VERTICAL);
        layoutTop.setBackground(drawables.fromBase64(context, drawables.jc_title_bg_png));

        LayoutParams topParams = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                dpToPx(48)
        );
        layoutTop.setLayoutParams(topParams);
        addView(layoutTop);

        // Loading indicator
        loading = new ProgressBar(context);
        loading.setId(View.generateViewId());
        loading.setTag("loading");
        loading.setIndeterminateDrawable(drawables.jc_loading(context));
        LayoutParams loadingParams = new LayoutParams(
                dpToPx(60),
                dpToPx(60)
        );
        loadingParams.addRule(CENTER_HORIZONTAL, RelativeLayout.TRUE);
        loadingParams.addRule(CENTER_VERTICAL, RelativeLayout.TRUE);
        loading.setLayoutParams(loadingParams);
        loading.setVisibility(View.INVISIBLE);
        addView(loading);

        // Start button
        startButton = new ImageView(context);
        startButton.setId(View.generateViewId());
        startButton.setTag("start");
        startButton.setImageDrawable(drawables.jc_click_play_selector(context));
        LayoutParams startParams = new LayoutParams(
                dpToPx(60),
                dpToPx(60)
        );
        startParams.addRule(CENTER_HORIZONTAL, RelativeLayout.TRUE);
        startParams.addRule(CENTER_VERTICAL, RelativeLayout.TRUE);
        startButton.setLayoutParams(startParams);
        addView(startButton);
    }

    private int dpToPx(float dp) {
        return (int) (dp * getResources().getDisplayMetrics().density + 0.5f);
    }
}
