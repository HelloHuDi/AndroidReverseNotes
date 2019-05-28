package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.gridviewheaders.e;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map.Entry;

public final class a extends BaseAdapter implements e {
    int gLP = 10;
    private SimpleDateFormat kIy = new SimpleDateFormat(SQLiteLintUtil.YYYY_MM_DD_HH_mm);
    private Context mContext;
    int mOF = 9;
    com.tencent.mm.plugin.gallery.stub.a mOG = null;
    ArrayList<MediaItem> mOH = new ArrayList();
    ArrayList<MediaItem> mOI = new ArrayList();
    private b mOJ;
    int mOK;
    String mOL;
    LinkedList<a> mOM = new LinkedList();
    boolean mON = false;
    boolean mOO = true;
    private OnClickListener mOP = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(21360);
            if (view.getTag(R.id.bpz) instanceof Integer) {
                Integer num = (Integer) view.getTag(R.id.bpz);
                if (num == null) {
                    ab.e("MicroMsg.AlbumAdapter", "[onClick] null == position!");
                    AppMethodBeat.o(21360);
                    return;
                }
                MediaItem mediaItem = (MediaItem) a.this.mOH.get(num.intValue());
                if (mediaItem == null || bo.isNullOrNil(mediaItem.fPT)) {
                    ab.e("MicroMsg.AlbumAdapter", "[onClick] null == item!");
                    AppMethodBeat.o(21360);
                    return;
                }
                int i;
                boolean z;
                ab.i("MicroMsg.AlbumAdapter", "click Image path:" + mediaItem.fPT);
                if (a.this.mOI.contains(mediaItem)) {
                    a.this.mOI.indexOf(mediaItem);
                    a.this.mOI.remove(mediaItem);
                    i = 1;
                    z = false;
                } else {
                    if (com.tencent.mm.plugin.gallery.model.e.bBZ().hOZ == 3 && mediaItem != null && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                        int cs = com.tencent.mm.a.e.cs(mediaItem.fPT);
                        if (!((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().Jq(mediaItem.fPT)) {
                            try {
                                a.this.mOG.aK(13459, cs + ",1,,0");
                            } catch (RemoteException e) {
                                ab.printErrStackTrace("MicroMsg.AlbumAdapter", e, "", new Object[0]);
                            }
                            h.bQ(a.this.mContext, a.this.mContext.getString(R.string.c3w));
                            AppMethodBeat.o(21360);
                            return;
                        }
                    }
                    if ((a.this.mOK == 2 || a.this.mOK == 3) && (mediaItem instanceof VideoMediaItem) && !bo.isNullOrNil(a.this.mOL) && a.this.mOL.equals("album_business_bubble_media_by_coordinate") && ((VideoMediaItem) mediaItem).fPW >= (a.this.gLP * 1000) + 500) {
                        h.bQ(a.this.mContext, a.this.mContext.getResources().getString(R.string.c4d, new Object[]{Integer.valueOf(a.this.gLP)}));
                        AppMethodBeat.o(21360);
                        return;
                    } else if (a.this.mOI.size() < a.this.mOF) {
                        a.this.mOI.add(mediaItem);
                        a.this.mOI.size();
                        i = 0;
                        z = false;
                    } else {
                        i = 1;
                        z = true;
                    }
                }
                if (z) {
                    if (a.this.mOK == 1) {
                        h.bQ(a.this.mContext, a.this.mContext.getResources().getQuantityString(R.plurals.m, a.this.mOF, new Object[]{Integer.valueOf(a.this.mOF)}));
                    } else if (a.this.mOK == 2) {
                        h.bQ(a.this.mContext, a.this.mContext.getResources().getQuantityString(R.plurals.o, a.this.mOF, new Object[]{Integer.valueOf(a.this.mOF)}));
                    } else {
                        h.bQ(a.this.mContext, a.this.mContext.getResources().getQuantityString(R.plurals.n, a.this.mOF, new Object[]{Integer.valueOf(a.this.mOF)}));
                    }
                } else if (a.this.mOJ != null) {
                    a.this.mOJ.W(a.this.mOI.size(), num.intValue(), i);
                }
                if (1 == i) {
                    ((CheckBox) view.getTag(R.id.bpy)).setChecked(false);
                    ((View) view.getTag(R.id.dnu)).setVisibility(0);
                    ((View) view.getTag(R.id.dnu)).setBackgroundResource(R.color.sb);
                    AppMethodBeat.o(21360);
                    return;
                }
                ((CheckBox) view.getTag(R.id.bpy)).setChecked(true);
                ((View) view.getTag(R.id.dnu)).setVisibility(0);
                ((View) view.getTag(R.id.dnu)).setBackgroundResource(R.color.rr);
                AppMethodBeat.o(21360);
                return;
            }
            AppMethodBeat.o(21360);
        }
    };

    static class d {
        public ImageView mOW;
        public ImageView mOX;
        public RelativeLayout mOY;
        public TextView mOZ;
        public TextView mPa;
        public ImageView mPb;
        public ImageView mPc;
        public ImageView mPd;
        public CheckBox moo;
        public View mop;

        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    public interface b {
        void W(int i, int i2, int i3);
    }

    public interface a {
        View getView();
    }

    static class c implements Runnable {
        private static HashMap<TextView, c> mOU = new HashMap();
        private WeakReference<TextView> lWO;
        private VideoMediaItem mOS;
        private a mOT;

        interface a {
            void a(c cVar, int i);
        }

        static /* synthetic */ void e(TextView textView, int i) {
            AppMethodBeat.i(21370);
            d(textView, i);
            AppMethodBeat.o(21370);
        }

        private c(TextView textView, VideoMediaItem videoMediaItem, a aVar) {
            AppMethodBeat.i(21363);
            this.lWO = new WeakReference(textView);
            this.mOS = videoMediaItem;
            this.mOT = aVar;
            AppMethodBeat.o(21363);
        }

        private void h(TextView textView) {
            AppMethodBeat.i(21364);
            this.lWO = new WeakReference(textView);
            AppMethodBeat.o(21364);
        }

        static {
            AppMethodBeat.i(21371);
            AppMethodBeat.o(21371);
        }

        static void a(TextView textView, VideoMediaItem videoMediaItem) {
            Entry entry = null;
            AppMethodBeat.i(21365);
            if (textView == null || videoMediaItem == null) {
                ab.e("MicroMsg.AlbumAdapter", "Error input for duration fetcher");
                AppMethodBeat.o(21365);
                return;
            }
            if (mOU.containsKey(textView)) {
                c cVar = (c) mOU.get(textView);
                if (cVar.mOS.equals(videoMediaItem)) {
                    AppMethodBeat.o(21365);
                    return;
                } else if (textView.equals(cVar.lWO.get())) {
                    cVar.h(null);
                }
            }
            if (videoMediaItem.fPW >= 0) {
                ab.i("MicroMsg.AlbumAdapter", "Directly attach durationMs %d to tv, path %s", Integer.valueOf(videoMediaItem.fPW), videoMediaItem);
                d(textView, videoMediaItem.fPW);
                mOU.remove(textView);
                AppMethodBeat.o(21365);
                return;
            }
            textView.setText("");
            c cVar2 = new c(textView, videoMediaItem, new a() {
                public final void a(c cVar, int i) {
                    AppMethodBeat.i(21362);
                    if (cVar == null || cVar.lWO == null) {
                        AppMethodBeat.o(21362);
                        return;
                    }
                    TextView textView = (TextView) cVar.lWO.get();
                    if (textView == null) {
                        AppMethodBeat.o(21362);
                        return;
                    }
                    c.e(textView, i);
                    c.mOU.remove(textView);
                    AppMethodBeat.o(21362);
                }
            });
            if (com.tencent.mm.sdk.g.d.xDG.ao(cVar2)) {
                ab.i("MicroMsg.AlbumAdapter", "task has post to thread pool");
                for (Entry entry2 : mOU.entrySet()) {
                    if (cVar2.equals(entry2.getValue())) {
                        entry = entry2;
                        break;
                    }
                }
                if (entry == null || entry.getValue() == null) {
                    ab.e("MicroMsg.AlbumAdapter", "no entry found");
                    AppMethodBeat.o(21365);
                    return;
                }
                ((c) entry.getValue()).h(textView);
                mOU.remove(entry.getKey());
                mOU.put(textView, entry.getValue());
                AppMethodBeat.o(21365);
                return;
            }
            com.tencent.mm.sdk.g.d.post(cVar2, "load_duration_for_" + videoMediaItem.fPT);
            mOU.put(textView, cVar2);
            AppMethodBeat.o(21365);
        }

        private static void d(TextView textView, int i) {
            AppMethodBeat.i(21366);
            if (textView == null) {
                AppMethodBeat.o(21366);
            } else if (i < 0) {
                textView.setText("--:--");
                AppMethodBeat.o(21366);
            } else {
                int round = Math.round(((float) i) / 1000.0f);
                textView.setText(String.format(Locale.CHINA, "%d:%02d", new Object[]{Integer.valueOf(round / 60), Integer.valueOf(round % 60)}));
                AppMethodBeat.o(21366);
            }
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(21367);
            if (obj == null || !(obj instanceof c)) {
                AppMethodBeat.o(21367);
                return false;
            }
            boolean equals = this.mOS.equals(((c) obj).mOS);
            AppMethodBeat.o(21367);
            return equals;
        }

        public final int hashCode() {
            AppMethodBeat.i(21368);
            int hashCode = this.mOS.hashCode();
            AppMethodBeat.o(21368);
            return hashCode;
        }

        public final void run() {
            AppMethodBeat.i(21369);
            MediaExtractor mediaExtractor = new MediaExtractor();
            String Wy = this.mOS.Wy();
            try {
                mediaExtractor.setDataSource(Wy);
                int trackCount = mediaExtractor.getTrackCount();
                MediaFormat mediaFormat = null;
                MediaFormat mediaFormat2 = null;
                for (int i = 0; i < trackCount; i++) {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                    if (trackFormat.containsKey("mime")) {
                        String string = trackFormat.getString("mime");
                        ab.d("MicroMsg.AlbumAdapter", "find video mime : %s", string);
                        if (string != null) {
                            if (string.startsWith("video/")) {
                                if (mediaFormat2 == null) {
                                    mediaFormat2 = trackFormat;
                                }
                            } else if (string.startsWith("audio/") && r0 == null) {
                                mediaFormat = trackFormat;
                            }
                            if (!(mediaFormat == null || r1 == null)) {
                                break;
                            }
                        }
                        continue;
                    } else {
                        ab.d("MicroMsg.AlbumAdapter", "find video mime : not found.");
                    }
                }
                MediaFormat mediaFormat3 = mediaFormat;
                if (this.mOS != null) {
                    if (mediaFormat2 != null) {
                        this.mOS.fPW = !mediaFormat2.containsKey("durationUs") ? 0 : (int) (mediaFormat2.getLong("durationUs") / 1000);
                        this.mOS.videoHeight = !mediaFormat2.containsKey("height") ? 0 : mediaFormat2.getInteger("height");
                        this.mOS.videoWidth = !mediaFormat2.containsKey("width") ? 0 : mediaFormat2.getInteger("width");
                        this.mOS.fPU = !mediaFormat2.containsKey("mime") ? "" : mediaFormat2.getString("mime");
                        this.mOS.videoBitRate = !mediaFormat2.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) ? 0 : mediaFormat2.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
                        this.mOS.fPX = !mediaFormat2.containsKey("i-frame-interval") ? 0 : mediaFormat2.getInteger("i-frame-interval");
                        this.mOS.videoFrameRate = !mediaFormat2.containsKey("frame-rate") ? 0 : mediaFormat2.getInteger("frame-rate");
                        this.mOS.eXL = SightVideoJNI.getMp4Rotate(Wy);
                    }
                    if (mediaFormat3 != null) {
                        this.mOS.fPV = !mediaFormat3.containsKey("mime") ? "" : mediaFormat3.getString("mime");
                    }
                }
                ab.d("MicroMsg.AlbumAdapter", "mediaItem format:%s, videoPath:%s", mediaFormat2, Wy);
                mediaExtractor.release();
            } catch (Exception e) {
                ab.d("MicroMsg.AlbumAdapter", "Video extractor init failed. video path = [%s] e = [%s]", Wy, e.getMessage());
                mediaExtractor.release();
            } catch (Throwable th) {
                mediaExtractor.release();
                AppMethodBeat.o(21369);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (this.mOT != null) {
                    this.mOT.a(this, this.mOS.fPW);
                }
                AppMethodBeat.o(21369);
                return;
            }
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(21361);
                    if (c.this.mOT != null) {
                        c.this.mOT.a(c.this, c.this.mOS.fPW);
                    }
                    AppMethodBeat.o(21361);
                }
            });
            AppMethodBeat.o(21369);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(21385);
        MediaItem ws = ws(i);
        AppMethodBeat.o(21385);
        return ws;
    }

    public a(Context context, b bVar) {
        int i = 0;
        AppMethodBeat.i(21372);
        this.mContext = context;
        this.mOJ = bVar;
        while (i < 32) {
            this.mOH.add(new ImageMediaItem());
            i++;
        }
        AppMethodBeat.o(21372);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(21373);
        if (aVar == null) {
            ab.w("MicroMsg.AlbumAdapter", "addHeader error, header is null");
            AppMethodBeat.o(21373);
            return;
        }
        this.mOM.remove(aVar);
        this.mOM.add(aVar);
        AppMethodBeat.o(21373);
    }

    public final ArrayList<String> bCw() {
        AppMethodBeat.i(21374);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.mOI.iterator();
        while (it.hasNext()) {
            arrayList.add(((MediaItem) it.next()).fPT);
        }
        AppMethodBeat.o(21374);
        return arrayList;
    }

    public final void C(ArrayList<String> arrayList) {
        AppMethodBeat.i(21375);
        ab.d("MicroMsg.AlbumAdapter", "before set selected paths, selected[%s]", this.mOI);
        this.mOI.clear();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                MediaItem a = MediaItem.a(0, 0, str, str, "");
                if (com.tencent.mm.plugin.gallery.model.e.bCb() != null) {
                    int indexOf = com.tencent.mm.plugin.gallery.model.e.bCb().indexOf(a);
                    if (indexOf >= 0) {
                        a = (MediaItem) com.tencent.mm.plugin.gallery.model.e.bCb().get(indexOf);
                        if (a != null && a.getType() == 2) {
                            this.mOI.add(MediaItem.a(2, 0, str, "", ""));
                        }
                    }
                }
                ab.d("MicroMsg.AlbumAdapter", "media item no exist on preview items.");
                this.mOI.add(MediaItem.a(1, 0, str, "", ""));
            }
        }
        ab.d("MicroMsg.AlbumAdapter", "after set selected paths, selected[%s]", this.mOI);
        AppMethodBeat.o(21375);
    }

    public final ArrayList<MediaItem> wr(int i) {
        AppMethodBeat.i(21376);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.mOH.iterator();
        while (it.hasNext()) {
            MediaItem mediaItem = (MediaItem) it.next();
            if (mediaItem.getType() == i) {
                arrayList.add(mediaItem);
            }
        }
        AppMethodBeat.o(21376);
        return arrayList;
    }

    public final int getCount() {
        AppMethodBeat.i(21377);
        int size = this.mOM.size() + this.mOH.size();
        AppMethodBeat.o(21377);
        return size;
    }

    public final int getViewTypeCount() {
        AppMethodBeat.i(21378);
        int size = this.mOM.size() + 1;
        AppMethodBeat.o(21378);
        return size;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(21379);
        if (i < this.mOM.size()) {
            AppMethodBeat.o(21379);
            return i;
        }
        i = this.mOM.size();
        AppMethodBeat.o(21379);
        return i;
    }

    public final MediaItem ws(int i) {
        AppMethodBeat.i(21380);
        if (i < this.mOM.size()) {
            ab.i("MicroMsg.AlbumAdapter", "get header, pos[%d]", Integer.valueOf(i));
            AppMethodBeat.o(21380);
            return null;
        }
        int size = i - this.mOM.size();
        MediaItem imageMediaItem;
        if (size >= this.mOH.size()) {
            ab.w("MicroMsg.AlbumAdapter", "get item error, media items size[%d], adjustPos[%d]", Integer.valueOf(this.mOH.size()), Integer.valueOf(size));
            imageMediaItem = new ImageMediaItem();
            imageMediaItem.mOl = bo.anU();
            AppMethodBeat.o(21380);
            return imageMediaItem;
        }
        imageMediaItem = (MediaItem) this.mOH.get(size);
        AppMethodBeat.o(21380);
        return imageMediaItem;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(21381);
        if (i < this.mOM.size()) {
            ab.i("MicroMsg.AlbumAdapter", "position[%d], get header view", Integer.valueOf(i));
            View view2 = ((a) this.mOM.get(i)).getView();
            AppMethodBeat.o(21381);
            return view2;
        }
        String str;
        View inflate;
        d dVar;
        int size = i - this.mOM.size();
        MediaItem mediaItem = (MediaItem) this.mOH.get(size);
        if (view == null || !(view.getTag() instanceof d)) {
            String str2 = "MicroMsg.AlbumAdapter";
            str = "converview is null?[%B]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(view == null);
            ab.d(str2, str, objArr);
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.apn, viewGroup, false);
            d dVar2 = new d();
            dVar2.mOW = (ImageView) inflate.findViewById(R.id.dnv);
            dVar2.mOX = (ImageView) inflate.findViewById(R.id.akx);
            dVar2.mOY = (RelativeLayout) inflate.findViewById(R.id.cik);
            dVar2.mOZ = (TextView) inflate.findViewById(R.id.dnr);
            dVar2.moo = (CheckBox) inflate.findViewById(R.id.bpy);
            dVar2.mPa = (TextView) inflate.findViewById(R.id.e5y);
            dVar2.mop = inflate.findViewById(R.id.bpz);
            dVar2.mPb = (ImageView) inflate.findViewById(R.id.dnu);
            dVar2.mop.setOnClickListener(this.mOP);
            dVar2.mop.setTag(R.id.bpy, dVar2.moo);
            dVar2.mop.setTag(R.id.e5y, dVar2.mPa);
            dVar2.mop.setTag(R.id.dnu, dVar2.mPb);
            if (com.tencent.mm.plugin.gallery.model.e.bBZ().hOZ == 0 || com.tencent.mm.plugin.gallery.model.e.bBZ().hOZ == 5 || com.tencent.mm.plugin.gallery.model.e.bBZ().hOZ == 10 || com.tencent.mm.plugin.gallery.model.e.bBZ().hOZ == 11 || com.tencent.mm.plugin.gallery.model.e.bBZ().hOZ == 14) {
                dVar2.moo.setVisibility(8);
                dVar2.mPa.setVisibility(8);
                dVar2.mop.setVisibility(8);
                dVar2.mPb.setVisibility(8);
            }
            dVar2.mPc = (ImageView) inflate.findViewById(R.id.dns);
            dVar2.mPd = (ImageView) inflate.findViewById(R.id.dnt);
            inflate.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
            inflate = view;
        }
        if (mediaItem == null) {
            ab.e("MicroMsg.AlbumAdapter", "get item failed");
            AppMethodBeat.o(21381);
            return inflate;
        }
        dVar.mOW.setVisibility(0);
        if (mediaItem.getType() == 2) {
            dVar.mOY.setVisibility(0);
            c.a(dVar.mOZ, (VideoMediaItem) mediaItem);
        } else {
            dVar.mOY.setVisibility(8);
        }
        if (mediaItem.mMimeType.equalsIgnoreCase("edit")) {
            dVar.mPd.setVisibility(0);
        } else {
            dVar.mPd.setVisibility(8);
        }
        str = mediaItem.Wy();
        String str3 = mediaItem.fPT;
        if (bo.isNullOrNil(str) && bo.isNullOrNil(str3)) {
            ab.e("MicroMsg.AlbumAdapter", "null or nil filepath: ".concat(String.valueOf(size)));
            AppMethodBeat.o(21381);
            return inflate;
        }
        dVar.mop.setTag(R.id.bpz, Integer.valueOf(size));
        int i2 = R.string.dcm;
        if (mediaItem.getType() == 2) {
            i2 = R.string.f1v;
        }
        ab.d("MicroMsg.AlbumAdapter", "thumbFilaPath: %s | origFilePath: %s | contentDescription %s", str, str3, viewGroup.getContext().getString(i2, new Object[]{Integer.valueOf((i + 1) - this.mOM.size()), this.kIy.format(new Date(mediaItem.mOl))}));
        dVar.mOX.setContentDescription(r2);
        final ImageView imageView = dVar.mOW;
        h.a(dVar.mOX, mediaItem.getType(), str, str3, mediaItem.mOk, -1, new com.tencent.mm.plugin.gallery.ui.h.a() {
            public final void bCx() {
                AppMethodBeat.i(21359);
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                AppMethodBeat.o(21359);
            }
        });
        if (this.mON) {
            if (mediaItem.getType() == 2) {
                dVar.moo.setVisibility(8);
                dVar.mPa.setVisibility(8);
                dVar.mop.setVisibility(8);
                dVar.mPb.setVisibility(8);
            } else if (this.mOI.contains(mediaItem)) {
                dVar.moo.setChecked(true);
                TextView textView = dVar.mPa;
                StringBuilder stringBuilder = new StringBuilder();
                if (mediaItem == null) {
                    i2 = -1;
                } else {
                    i2 = this.mOI.indexOf(mediaItem);
                }
                textView.setText(stringBuilder.append(i2).toString());
                dVar.mPb.setBackgroundResource(R.color.rr);
                dVar.mop.setVisibility(0);
                dVar.moo.setVisibility(0);
                dVar.mPb.setVisibility(0);
            } else {
                dVar.mPa.setVisibility(8);
                dVar.moo.setChecked(false);
                dVar.mPb.setBackgroundResource(R.color.sb);
                dVar.moo.setVisibility(0);
                dVar.mop.setVisibility(0);
                dVar.mPb.setVisibility(0);
            }
        } else if (this.mOI.contains(mediaItem)) {
            dVar.moo.setChecked(true);
            dVar.mPb.setVisibility(0);
            dVar.mPb.setBackgroundResource(R.color.rr);
        } else {
            dVar.moo.setChecked(false);
            dVar.mPa.setVisibility(8);
            dVar.mPb.setVisibility(0);
            dVar.mPb.setBackgroundResource(R.color.sb);
        }
        if ((com.tencent.mm.plugin.gallery.model.e.bBZ().hOZ == 3 || com.tencent.mm.plugin.gallery.model.e.bBZ().hOZ == 11) && mediaItem != null && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            dVar.mPc.setVisibility(0);
        } else {
            dVar.mPc.setVisibility(8);
        }
        AppMethodBeat.o(21381);
        return inflate;
    }

    public final long tw(int i) {
        AppMethodBeat.i(21382);
        if (i < this.mOM.size()) {
            ab.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", Integer.valueOf(i));
            i = this.mOM.size();
        }
        ab.v("MicroMsg.AlbumAdapter", "getHeaderId, adjust pos[%d], date[%d] date[%s], headerID[%d]", Integer.valueOf(i), Long.valueOf(ws(i).mOl), r1, Long.valueOf(com.tencent.mm.ui.gridviewheaders.a.dJg().b(new Date(ws(i).mOl))));
        AppMethodBeat.o(21382);
        return com.tencent.mm.ui.gridviewheaders.a.dJg().b(new Date(ws(i).mOl));
    }

    public final String wt(int i) {
        AppMethodBeat.i(21383);
        if (i < this.mOM.size()) {
            ab.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", Integer.valueOf(i));
            i = this.mOM.size();
        }
        MediaItem ws = ws(i);
        String a;
        if (bo.isNullOrNil(ws.mOn)) {
            a = com.tencent.mm.ui.gridviewheaders.a.dJg().a(new Date(ws.mOl), this.mContext);
            AppMethodBeat.o(21383);
            return a;
        }
        a = ws.mOn;
        AppMethodBeat.o(21383);
        return a;
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        View textView;
        AppMethodBeat.i(21384);
        if (i < this.mOM.size()) {
            ab.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", Integer.valueOf(i));
            i = this.mOM.size();
        }
        if (view == null || view.getParent() != null) {
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            textView = new TextView(this.mContext);
            textView.setBackgroundResource(R.drawable.a_q);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.nc);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.nc);
            textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            textView.setTextColor(this.mContext.getResources().getColor(R.color.pl));
            textView.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(R.dimen.kr));
            textView.setTypeface(null, 1);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = view;
        }
        ab.v("MicroMsg.AlbumAdapter", "getHeaderView, adjust pos[%d], date[%d] date[%s], headerStr[%s]", Integer.valueOf(i), Long.valueOf(r0.mOl), new Date(ws(i).mOl), com.tencent.mm.ui.gridviewheaders.a.dJg().a(new Date(ws(i).mOl), this.mContext));
        ((TextView) textView).setText(r3);
        AppMethodBeat.o(21384);
        return textView;
    }
}
