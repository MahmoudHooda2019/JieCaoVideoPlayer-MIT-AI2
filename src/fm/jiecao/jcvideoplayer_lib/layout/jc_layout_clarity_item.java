package fm.jiecao.jcvideoplayer_lib.layout;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

public class jc_layout_clarity_item extends TextView {

    public jc_layout_clarity_item(Context context) {
        super(context);

        // Layout width: match_parent, height: wrap_content
        setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        // Set gravity to center
        setGravity(Gravity.CENTER);

        // Set padding in dp
        int paddingTopBottom = dpToPx(8);
        int paddingLeftRight = dpToPx(10);
        setPadding(paddingLeftRight, paddingTopBottom, paddingLeftRight, paddingTopBottom);

        // Set text color to white
        setTextColor(Color.WHITE);

        // Set text size to 14sp
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);

        // Optional: set ID or tag
        setId(generateViewId());
        setTag("video_item");
    }

    private int dpToPx(float dp) {
        return (int) (dp * getResources().getDisplayMetrics().density + 0.5f);
    }
}
