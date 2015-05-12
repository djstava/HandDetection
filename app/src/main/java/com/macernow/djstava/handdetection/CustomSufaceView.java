package com.macernow.djstava.handdetection;

import android.content.Context;
import android.util.AttributeSet;

import org.opencv.android.JavaCameraView;

import java.util.List;

/**
 * Created by djstava on 15/5/6.
 */
public class CustomSufaceView extends JavaCameraView {

    private static final String TAG = "OpenCustomSufaceView";

    public CustomSufaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public List<String> getEffectList() {
        return mCamera.getParameters().getSupportedColorEffects();
    }

    public boolean isEffectSupported() {
        return (mCamera.getParameters().getColorEffect() != null);
    }

    public String getEffect() {
        return mCamera.getParameters().getColorEffect();
    }

    public void setEffect(String effect) {
        android.hardware.Camera.Parameters params = mCamera.getParameters();
        params.setColorEffect(effect);
        mCamera.setParameters(params);
    }

    public android.hardware.Camera.Parameters getParameters(){
        android.hardware.Camera.Parameters params = mCamera.getParameters();
        return params;
    }

    public void setParameters(android.hardware.Camera.Parameters params){
        mCamera.setParameters(params);
    }

    public List<android.hardware.Camera.Size> getResolutionList() {
        return mCamera.getParameters().getSupportedPreviewSizes();
    }

    public void setResolution(android.hardware.Camera.Size resolution) {
        disconnectCamera();
        mMaxHeight = resolution.height;
        mMaxWidth = resolution.width;
        connectCamera(getWidth(), getHeight());
    }

    //for test only
    public void setResolution() {
        disconnectCamera();
        mMaxHeight = 600;
        mMaxWidth = 800;
        connectCamera(getWidth(),getHeight());
    }

    public android.hardware.Camera.Size getResolution() {
        return mCamera.getParameters().getPreviewSize();
    }
}