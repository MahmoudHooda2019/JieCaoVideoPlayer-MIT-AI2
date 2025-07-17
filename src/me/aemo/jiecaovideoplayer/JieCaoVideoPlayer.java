package me.aemo.jiecaovideoplayer;


import android.view.ViewGroup;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.annotations.SimpleFunction;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

@DesignerComponent(
	version = 1,
	versionName = "1.0",
	description = "Jie Cao Video Player Extension, Developed by AEMO.",
	iconName = "icon.png"
)
public class JieCaoVideoPlayer extends AndroidNonvisibleComponent {

    private final ComponentContainer container;

    private JCVideoPlayerStandard videoPlayer;

  public JieCaoVideoPlayer(ComponentContainer container) {
    super(container.$form());
    this.container = container;
  }

  @SimpleFunction
    public void Initialize(AndroidViewComponent view, String title, String video, String image){
      if (videoPlayer == null){
          videoPlayer = new JCVideoPlayerStandard(container.$context());
          videoPlayer.setUp(video, JCVideoPlayerStandard.NORMAL_ORIENTATION, title);
          ImageLoader loader = new ImageLoader();
          loader.loadImage(image, videoPlayer.thumbImageView);

          ViewGroup vg = (ViewGroup) view.getView();
          if (vg.getChildCount() > 1) vg.removeAllViews();
          vg.addView(videoPlayer, new ViewGroup.LayoutParams(-1, -1));
      }
  }


}
