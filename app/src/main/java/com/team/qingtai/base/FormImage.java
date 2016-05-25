package com.team.qingtai.base;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * Created by ymh on 2016/5/24.
 */
public class FormImage {

    private String imagePath;
    private final File file;

    public FormImage(String imagePath) {
        this.imagePath = imagePath;
        file = new File(imagePath);
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getmName() {
        return "pids";
    }

    public String getmFileName() {
        String suffix = "123";
        final int idx = imagePath.lastIndexOf("/");
        if (idx > 0) {
            suffix = imagePath.substring(idx + 1);
        }
        return suffix;
    }


    public byte[] getValue() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imagePath, options);
        options.inSampleSize = calculateInSampleSize(options, 480, 800);

        options.inJustDecodeBounds = false;
        Bitmap mBitmap = BitmapFactory.decodeFile(imagePath, options);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);

        if (!mBitmap.isRecycled() && mBitmap != null) {
            mBitmap.recycle();
            System.gc();
        }

        return bos.toByteArray();
    }

    public String getmMime() {
        return "image/" + getExtension(file);
    }

    private static String getExtension(final File file) {
        String suffix = "";
        String name = file.getName();
        final int idx = name.lastIndexOf(".");
        if (idx > 0) {
            suffix = name.substring(idx + 1);
        }
        return suffix;
    }

    private int calculateInSampleSize(BitmapFactory.Options options,
                                      int reqWidth, int reqHeight) {
        // 源图片的高度和宽度
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            // 计算出实际宽高和目标宽高的比率
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            // 选择宽和高中最小的比率作为inSampleSize的值，这样可以保证最终图片的宽和高
            // 一定都会大于等于目标的宽和高。
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }

}
