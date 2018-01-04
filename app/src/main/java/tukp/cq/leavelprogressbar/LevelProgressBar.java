package tukp.cq.leavelprogressbar;

import android.content.Context;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/**
 * 2018\1\4
 * @author tukp
 * 等级进度条demo
 */
public class LevelProgressBar extends ProgressBar {

    private final int EMPTY_MESSAGE = 1;

    // xml 中的自定义属性

    private int levelTextChooseColor;
    private int levelTextUnChooseColor;
    private int levelTextSize;
    private int progressStartColor;
    private int progressEndColor;
    private int progressBackGroundColor;
    private int progressHeight;

    //代码中需要设置的属性

    private int levels;
    private int currentLevel;
    private int targetProgress;
    private int animInterval;
    private String[] levelTexts ;

    private Paint mPaint;
    private int mTotalWidth;
    int textHeight;

    private Handler handler;

    {
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                int progress = getProgress();

                //根据进度条调整进度
                if (progress < targetProgress){
                    setProgress(++progress);
                    handler.sendEmptyMessageDelayed(EMPTY_MESSAGE,animInterval);
                }else if (progress > targetProgress){
                    setProgress(--progress);
                    handler.sendEmptyMessageDelayed(EMPTY_MESSAGE,animInterval);
                }else {
                    handler.removeMessages(EMPTY_MESSAGE);
                }
            }
        };
    }

    public LevelProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LevelProgressBar(Context context, AttributeSet attrs,int defStyleAttr) {
        super(context, attrs,defStyleAttr);
    }
}
