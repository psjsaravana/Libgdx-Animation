package com.psj.saravana.myfirsatanimation.android;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Saravana on 13-08-2015.
 */
public class MyGameAnimation implements ApplicationListener {
    SpriteBatch batch;
    Context appContext;
    Texture texture;
    Animation jumpAnimation;
    TextureRegion[] jumpFrames;
    TextureRegion currentFrame;
    float stateTime;

    public MyGameAnimation(Context applicationContext) {
        this.appContext=applicationContext;
    }

    @Override
    public void create() {
       batch=new SpriteBatch();
       texture=new Texture(Gdx.files.internal("SpriteSheet.png"));
       TextureRegion[][] tmpArray = TextureRegion.split(texture,texture.getWidth()/30,texture.getHeight());
       jumpFrames = new TextureRegion[30];
        int index = 0;
        for (int j=0;j<1;j++)
        {
            for(int i=0;i<30;i++)
            {
                jumpFrames[index++]=tmpArray[j][i];
            }
        }
        jumpAnimation=new Animation(0.05f,jumpFrames);
        stateTime =0f;
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame=jumpAnimation.getKeyFrame(stateTime,true);
        batch.begin();
       // Log.i("Saravana...","Saravana Batch Begin");
        //batch.draw(currentFrame,0,0);
        batch.end();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
    @Override
    public void dispose() {
        //batch.dispose();
        texture.dispose();
        batch.dispose();
    }
}
