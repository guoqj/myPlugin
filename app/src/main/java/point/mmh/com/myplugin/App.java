package point.mmh.com.myplugin;

import android.app.Application;

import com.hunter.library.timing.IBlockHandler;
import com.hunter.library.timing.impl.RankingBlockHandler;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
      //  IBlockHandler customBlockManager = new RankingBlockHandler();
       // customBlockManager.dump();
        SpeechUtility.createUtility(getApplicationContext(), SpeechConstant.APPID +"=5be0292f");
    }
}
