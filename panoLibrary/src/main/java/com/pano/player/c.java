package com.pano.player;

import com.pano.player.a.ResultCallback;
import com.player.panoplayer.PanoPlayer;
import com.player.panoplayer.PanoPlayerUrl;
import com.squareup.okhttp.Request;

public class c {

    public static void a(final PanoPlayer pp,String deviceId) {
        a.c(deviceId,new ResultCallback() {

            @Override
            public void onResponse(String res) {
                b(pp, res);
            }

            @Override
            public void onError(Request request, Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void b(PanoPlayer pp, String url) {
        PanoPlayerUrl c = new PanoPlayerUrl();
        String e = null;
        try {
            e = String.format(new d().h(d.b), url);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        c.setXmlContent(e);
        pp.Play(c);
    }

    public static void d(PanoPlayer pp, String videoUrl) {
        PanoPlayerUrl panoplayerurl = new PanoPlayerUrl();
        panoplayerurl.SetVideoUrlImage(videoUrl, "");
        pp.Play(panoplayerurl);
    }
}
