package fm.jiecao.jcvideoplayer_lib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;
import fm.jiecao.jcvideoplayer_lib.layout.jc_layout_base;
import fm.jiecao.jcvideoplayer_lib.values.drawables;

/**
 * Manage UI
 * Created by Nathen
 * On 2016/04/10 15:45
 */
public class JCVideoPlayerSimple extends JCVideoPlayer {

    private final Context context;

    public JCVideoPlayerSimple(Context context) {
        super(context);
        this.context = context;
    }

    public JCVideoPlayerSimple(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    public View getLayoutView() {
        return new jc_layout_base(context);
        //return R.layout.jc_layout_base;
    }

    @Override
    public void setUp(String url, int screen, Object... objects) {
        super.setUp(url, screen, objects);
        updateFullscreenButton();
        fullscreenButton.setVisibility(View.GONE);
    }

    private void updateStartImage() {
        if (currentState == CURRENT_STATE_PLAYING) {
            startButton.setImageDrawable(drawables.jc_click_pause_selector(context));
        } else if (currentState == CURRENT_STATE_ERROR) {
            startButton.setImageDrawable(drawables.jc_click_error_selector(context));
        } else {
            startButton.setImageDrawable(drawables.jc_click_play_selector(context));
        }
    }

    public void updateFullscreenButton() {
        if (currentScreen == SCREEN_WINDOW_FULLSCREEN) {
            fullscreenButton.setImageDrawable(drawables.fromBase64(context, drawables.jc_shrink_png));
        } else {
            fullscreenButton.setImageDrawable(drawables.fromBase64(context, drawables.jc_enlarge_png));
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getTag() == "fullscreen" && currentState == CURRENT_STATE_NORMAL) {
            Toast.makeText(getContext(), "Play video first", Toast.LENGTH_SHORT).show();
            return;
        }
        super.onClick(v);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
            if (currentState == CURRENT_STATE_NORMAL) {
                Toast.makeText(getContext(), "Play video first", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        super.onProgressChanged(seekBar, progress, fromUser);
    }
}
