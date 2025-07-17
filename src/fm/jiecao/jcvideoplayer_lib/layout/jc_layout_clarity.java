package fm.jiecao.jcvideoplayer_lib.layout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import fm.jiecao.jcvideoplayer_lib.values.drawables;

public class jc_layout_clarity extends LinearLayout {

    public jc_layout_clarity(Context context) {
        super(context);

        // Set orientation and layout parameters
        setOrientation(VERTICAL);
        setLayoutParams(new LayoutParams(
                dpToPx(80),
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        // Set padding
        setPadding(
                0,
                dpToPx(10),
                0,
                dpToPx(16)
        );

        // Set background using helper drawable class
        setBackground(drawables.fromBase64(context, drawables.jc_clarity_popwindow_bg_9_png));

        // Optionally set ID and tag for identification
        setId(View.generateViewId());
        setTag("video_quality_wrapper_area");
    }

    private int dpToPx(float dp) {
        return (int) (dp * getResources().getDisplayMetrics().density + 0.5f);
    }
}
