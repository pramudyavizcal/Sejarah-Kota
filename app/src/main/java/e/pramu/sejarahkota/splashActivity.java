package e.pramu.sejarahkota;

import android.view.WindowManager;
import android.content.Intent;

import androidx.appcompat.app.ActionBar;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class splashActivity extends AwesomeSplash {
    @Override
    public void initSplash(ConfigSplash configSplash){

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //menambahkan background
        configSplash.setBackgroundColor(R.color.bg_splash);
        configSplash.setAnimCircularRevealDuration(2000);
        configSplash.setRevealFlagY(Flags.REVEAL_TOP);
        configSplash.setRevealFlagX(Flags.REVEAL_LEFT);

        //menambahkan logo
        configSplash.setLogoSplash(R.drawable.splash);
        configSplash.setAnimLogoSplashDuration(1000);
        configSplash.setAnimTitleTechnique(Techniques.BounceIn);

        //menambahkan title
        configSplash.setTitleSplash("Sejarah Kota");
        configSplash.setTitleTextColor(R.color.splash_title);
        configSplash.setTitleTextSize(30f);
        configSplash.setAnimTitleDuration(2000);
        configSplash.setAnimTitleTechnique(Techniques.DropOut);
    }
    @Override
    public void animationsFinished(){
        startActivity(new Intent(splashActivity.this, homeActivity.class));
    }
}
