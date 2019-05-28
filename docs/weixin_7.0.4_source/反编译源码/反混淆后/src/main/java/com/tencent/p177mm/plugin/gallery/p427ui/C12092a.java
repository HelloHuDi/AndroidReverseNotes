package com.tencent.p177mm.plugin.gallery.p427ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.gridviewheaders.C15894a;
import com.tencent.p177mm.p612ui.gridviewheaders.C46688e;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.gallery.model.C34237e;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.p177mm.plugin.gallery.p427ui.C20921h.C12100a;
import com.tencent.p177mm.plugin.gallery.stub.C34241a;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
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

/* renamed from: com.tencent.mm.plugin.gallery.ui.a */
public final class C12092a extends BaseAdapter implements C46688e {
    int gLP = 10;
    private SimpleDateFormat kIy = new SimpleDateFormat(SQLiteLintUtil.YYYY_MM_DD_HH_mm);
    private Context mContext;
    int mOF = 9;
    C34241a mOG = null;
    ArrayList<MediaItem> mOH = new ArrayList();
    ArrayList<MediaItem> mOI = new ArrayList();
    private C12094b mOJ;
    int mOK;
    String mOL;
    LinkedList<C12095a> mOM = new LinkedList();
    boolean mON = false;
    boolean mOO = true;
    private OnClickListener mOP = new C120902();

    /* renamed from: com.tencent.mm.plugin.gallery.ui.a$2 */
    class C120902 implements OnClickListener {
        C120902() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21360);
            if (view.getTag(2131823910) instanceof Integer) {
                Integer num = (Integer) view.getTag(2131823910);
                if (num == null) {
                    C4990ab.m7412e("MicroMsg.AlbumAdapter", "[onClick] null == position!");
                    AppMethodBeat.m2505o(21360);
                    return;
                }
                MediaItem mediaItem = (MediaItem) C12092a.this.mOH.get(num.intValue());
                if (mediaItem == null || C5046bo.isNullOrNil(mediaItem.fPT)) {
                    C4990ab.m7412e("MicroMsg.AlbumAdapter", "[onClick] null == item!");
                    AppMethodBeat.m2505o(21360);
                    return;
                }
                int i;
                boolean z;
                C4990ab.m7416i("MicroMsg.AlbumAdapter", "click Image path:" + mediaItem.fPT);
                if (C12092a.this.mOI.contains(mediaItem)) {
                    C12092a.this.mOI.indexOf(mediaItem);
                    C12092a.this.mOI.remove(mediaItem);
                    i = 1;
                    z = false;
                } else {
                    if (C34237e.bBZ().hOZ == 3 && mediaItem != null && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                        int cs = C1173e.m2560cs(mediaItem.fPT);
                        if (!((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35609Jq(mediaItem.fPT)) {
                            try {
                                C12092a.this.mOG.mo36247aK(13459, cs + ",1,,0");
                            } catch (RemoteException e) {
                                C4990ab.printErrStackTrace("MicroMsg.AlbumAdapter", e, "", new Object[0]);
                            }
                            C30379h.m48465bQ(C12092a.this.mContext, C12092a.this.mContext.getString(C25738R.string.c3w));
                            AppMethodBeat.m2505o(21360);
                            return;
                        }
                    }
                    if ((C12092a.this.mOK == 2 || C12092a.this.mOK == 3) && (mediaItem instanceof VideoMediaItem) && !C5046bo.isNullOrNil(C12092a.this.mOL) && C12092a.this.mOL.equals("album_business_bubble_media_by_coordinate") && ((VideoMediaItem) mediaItem).fPW >= (C12092a.this.gLP * 1000) + 500) {
                        C30379h.m48465bQ(C12092a.this.mContext, C12092a.this.mContext.getResources().getString(C25738R.string.c4d, new Object[]{Integer.valueOf(C12092a.this.gLP)}));
                        AppMethodBeat.m2505o(21360);
                        return;
                    } else if (C12092a.this.mOI.size() < C12092a.this.mOF) {
                        C12092a.this.mOI.add(mediaItem);
                        C12092a.this.mOI.size();
                        i = 0;
                        z = false;
                    } else {
                        i = 1;
                        z = true;
                    }
                }
                if (z) {
                    if (C12092a.this.mOK == 1) {
                        C30379h.m48465bQ(C12092a.this.mContext, C12092a.this.mContext.getResources().getQuantityString(C25738R.plurals.f9601m, C12092a.this.mOF, new Object[]{Integer.valueOf(C12092a.this.mOF)}));
                    } else if (C12092a.this.mOK == 2) {
                        C30379h.m48465bQ(C12092a.this.mContext, C12092a.this.mContext.getResources().getQuantityString(C25738R.plurals.f9603o, C12092a.this.mOF, new Object[]{Integer.valueOf(C12092a.this.mOF)}));
                    } else {
                        C30379h.m48465bQ(C12092a.this.mContext, C12092a.this.mContext.getResources().getQuantityString(C25738R.plurals.f9602n, C12092a.this.mOF, new Object[]{Integer.valueOf(C12092a.this.mOF)}));
                    }
                } else if (C12092a.this.mOJ != null) {
                    C12092a.this.mOJ.mo23918W(C12092a.this.mOI.size(), num.intValue(), i);
                }
                if (1 == i) {
                    ((CheckBox) view.getTag(2131823909)).setChecked(false);
                    ((View) view.getTag(2131826568)).setVisibility(0);
                    ((View) view.getTag(2131826568)).setBackgroundResource(C25738R.color.f12100sb);
                    AppMethodBeat.m2505o(21360);
                    return;
                }
                ((CheckBox) view.getTag(2131823909)).setChecked(true);
                ((View) view.getTag(2131826568)).setVisibility(0);
                ((View) view.getTag(2131826568)).setBackgroundResource(C25738R.color.f12084rr);
                AppMethodBeat.m2505o(21360);
                return;
            }
            AppMethodBeat.m2505o(21360);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.a$d */
    static class C12091d {
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

        private C12091d() {
        }

        /* synthetic */ C12091d(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.a$b */
    public interface C12094b {
        /* renamed from: W */
        void mo23918W(int i, int i2, int i3);
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.a$a */
    public interface C12095a {
        View getView();
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.a$c */
    static class C12096c implements Runnable {
        private static HashMap<TextView, C12096c> mOU = new HashMap();
        private WeakReference<TextView> lWO;
        private VideoMediaItem mOS;
        private C12097a mOT;

        /* renamed from: com.tencent.mm.plugin.gallery.ui.a$c$a */
        interface C12097a {
            /* renamed from: a */
            void mo23941a(C12096c c12096c, int i);
        }

        /* renamed from: com.tencent.mm.plugin.gallery.ui.a$c$1 */
        class C120981 implements Runnable {
            C120981() {
            }

            public final void run() {
                AppMethodBeat.m2504i(21361);
                if (C12096c.this.mOT != null) {
                    C12096c.this.mOT.mo23941a(C12096c.this, C12096c.this.mOS.fPW);
                }
                AppMethodBeat.m2505o(21361);
            }
        }

        /* renamed from: com.tencent.mm.plugin.gallery.ui.a$c$2 */
        static class C120992 implements C12097a {
            C120992() {
            }

            /* renamed from: a */
            public final void mo23941a(C12096c c12096c, int i) {
                AppMethodBeat.m2504i(21362);
                if (c12096c == null || c12096c.lWO == null) {
                    AppMethodBeat.m2505o(21362);
                    return;
                }
                TextView textView = (TextView) c12096c.lWO.get();
                if (textView == null) {
                    AppMethodBeat.m2505o(21362);
                    return;
                }
                C12096c.m20026e(textView, i);
                C12096c.mOU.remove(textView);
                AppMethodBeat.m2505o(21362);
            }
        }

        /* renamed from: e */
        static /* synthetic */ void m20026e(TextView textView, int i) {
            AppMethodBeat.m2504i(21370);
            C12096c.m20025d(textView, i);
            AppMethodBeat.m2505o(21370);
        }

        private C12096c(TextView textView, VideoMediaItem videoMediaItem, C12097a c12097a) {
            AppMethodBeat.m2504i(21363);
            this.lWO = new WeakReference(textView);
            this.mOS = videoMediaItem;
            this.mOT = c12097a;
            AppMethodBeat.m2505o(21363);
        }

        /* renamed from: h */
        private void m20027h(TextView textView) {
            AppMethodBeat.m2504i(21364);
            this.lWO = new WeakReference(textView);
            AppMethodBeat.m2505o(21364);
        }

        static {
            AppMethodBeat.m2504i(21371);
            AppMethodBeat.m2505o(21371);
        }

        /* renamed from: a */
        static void m20022a(TextView textView, VideoMediaItem videoMediaItem) {
            Entry entry = null;
            AppMethodBeat.m2504i(21365);
            if (textView == null || videoMediaItem == null) {
                C4990ab.m7412e("MicroMsg.AlbumAdapter", "Error input for duration fetcher");
                AppMethodBeat.m2505o(21365);
                return;
            }
            if (mOU.containsKey(textView)) {
                C12096c c12096c = (C12096c) mOU.get(textView);
                if (c12096c.mOS.equals(videoMediaItem)) {
                    AppMethodBeat.m2505o(21365);
                    return;
                } else if (textView.equals(c12096c.lWO.get())) {
                    c12096c.m20027h(null);
                }
            }
            if (videoMediaItem.fPW >= 0) {
                C4990ab.m7417i("MicroMsg.AlbumAdapter", "Directly attach durationMs %d to tv, path %s", Integer.valueOf(videoMediaItem.fPW), videoMediaItem);
                C12096c.m20025d(textView, videoMediaItem.fPW);
                mOU.remove(textView);
                AppMethodBeat.m2505o(21365);
                return;
            }
            textView.setText("");
            C12096c c12096c2 = new C12096c(textView, videoMediaItem, new C120992());
            if (C7305d.xDG.mo10150ao(c12096c2)) {
                C4990ab.m7416i("MicroMsg.AlbumAdapter", "task has post to thread pool");
                for (Entry entry2 : mOU.entrySet()) {
                    if (c12096c2.equals(entry2.getValue())) {
                        entry = entry2;
                        break;
                    }
                }
                if (entry == null || entry.getValue() == null) {
                    C4990ab.m7412e("MicroMsg.AlbumAdapter", "no entry found");
                    AppMethodBeat.m2505o(21365);
                    return;
                }
                ((C12096c) entry.getValue()).m20027h(textView);
                mOU.remove(entry.getKey());
                mOU.put(textView, entry.getValue());
                AppMethodBeat.m2505o(21365);
                return;
            }
            C7305d.post(c12096c2, "load_duration_for_" + videoMediaItem.fPT);
            mOU.put(textView, c12096c2);
            AppMethodBeat.m2505o(21365);
        }

        /* renamed from: d */
        private static void m20025d(TextView textView, int i) {
            AppMethodBeat.m2504i(21366);
            if (textView == null) {
                AppMethodBeat.m2505o(21366);
            } else if (i < 0) {
                textView.setText("--:--");
                AppMethodBeat.m2505o(21366);
            } else {
                int round = Math.round(((float) i) / 1000.0f);
                textView.setText(String.format(Locale.CHINA, "%d:%02d", new Object[]{Integer.valueOf(round / 60), Integer.valueOf(round % 60)}));
                AppMethodBeat.m2505o(21366);
            }
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(21367);
            if (obj == null || !(obj instanceof C12096c)) {
                AppMethodBeat.m2505o(21367);
                return false;
            }
            boolean equals = this.mOS.equals(((C12096c) obj).mOS);
            AppMethodBeat.m2505o(21367);
            return equals;
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(21368);
            int hashCode = this.mOS.hashCode();
            AppMethodBeat.m2505o(21368);
            return hashCode;
        }

        public final void run() {
            AppMethodBeat.m2504i(21369);
            MediaExtractor mediaExtractor = new MediaExtractor();
            String Wy = this.mOS.mo7504Wy();
            try {
                mediaExtractor.setDataSource(Wy);
                int trackCount = mediaExtractor.getTrackCount();
                MediaFormat mediaFormat = null;
                MediaFormat mediaFormat2 = null;
                for (int i = 0; i < trackCount; i++) {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                    if (trackFormat.containsKey("mime")) {
                        String string = trackFormat.getString("mime");
                        C4990ab.m7411d("MicroMsg.AlbumAdapter", "find video mime : %s", string);
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
                        C4990ab.m7410d("MicroMsg.AlbumAdapter", "find video mime : not found.");
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
                C4990ab.m7411d("MicroMsg.AlbumAdapter", "mediaItem format:%s, videoPath:%s", mediaFormat2, Wy);
                mediaExtractor.release();
            } catch (Exception e) {
                C4990ab.m7411d("MicroMsg.AlbumAdapter", "Video extractor init failed. video path = [%s] e = [%s]", Wy, e.getMessage());
                mediaExtractor.release();
            } catch (Throwable th) {
                mediaExtractor.release();
                AppMethodBeat.m2505o(21369);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (this.mOT != null) {
                    this.mOT.mo23941a(this, this.mOS.fPW);
                }
                AppMethodBeat.m2505o(21369);
                return;
            }
            C5004al.m7441d(new C120981());
            AppMethodBeat.m2505o(21369);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(21385);
        MediaItem ws = mo23935ws(i);
        AppMethodBeat.m2505o(21385);
        return ws;
    }

    public C12092a(Context context, C12094b c12094b) {
        int i = 0;
        AppMethodBeat.m2504i(21372);
        this.mContext = context;
        this.mOJ = c12094b;
        while (i < 32) {
            this.mOH.add(new ImageMediaItem());
            i++;
        }
        AppMethodBeat.m2505o(21372);
    }

    /* renamed from: a */
    public final void mo23926a(C12095a c12095a) {
        AppMethodBeat.m2504i(21373);
        if (c12095a == null) {
            C4990ab.m7420w("MicroMsg.AlbumAdapter", "addHeader error, header is null");
            AppMethodBeat.m2505o(21373);
            return;
        }
        this.mOM.remove(c12095a);
        this.mOM.add(c12095a);
        AppMethodBeat.m2505o(21373);
    }

    public final ArrayList<String> bCw() {
        AppMethodBeat.m2504i(21374);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.mOI.iterator();
        while (it.hasNext()) {
            arrayList.add(((MediaItem) it.next()).fPT);
        }
        AppMethodBeat.m2505o(21374);
        return arrayList;
    }

    /* renamed from: C */
    public final void mo23925C(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(21375);
        C4990ab.m7411d("MicroMsg.AlbumAdapter", "before set selected paths, selected[%s]", this.mOI);
        this.mOI.clear();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                MediaItem a = MediaItem.m5515a(0, 0, str, str, "");
                if (C34237e.bCb() != null) {
                    int indexOf = C34237e.bCb().indexOf(a);
                    if (indexOf >= 0) {
                        a = (MediaItem) C34237e.bCb().get(indexOf);
                        if (a != null && a.getType() == 2) {
                            this.mOI.add(MediaItem.m5515a(2, 0, str, "", ""));
                        }
                    }
                }
                C4990ab.m7410d("MicroMsg.AlbumAdapter", "media item no exist on preview items.");
                this.mOI.add(MediaItem.m5515a(1, 0, str, "", ""));
            }
        }
        C4990ab.m7411d("MicroMsg.AlbumAdapter", "after set selected paths, selected[%s]", this.mOI);
        AppMethodBeat.m2505o(21375);
    }

    /* renamed from: wr */
    public final ArrayList<MediaItem> mo23934wr(int i) {
        AppMethodBeat.m2504i(21376);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.mOH.iterator();
        while (it.hasNext()) {
            MediaItem mediaItem = (MediaItem) it.next();
            if (mediaItem.getType() == i) {
                arrayList.add(mediaItem);
            }
        }
        AppMethodBeat.m2505o(21376);
        return arrayList;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(21377);
        int size = this.mOM.size() + this.mOH.size();
        AppMethodBeat.m2505o(21377);
        return size;
    }

    public final int getViewTypeCount() {
        AppMethodBeat.m2504i(21378);
        int size = this.mOM.size() + 1;
        AppMethodBeat.m2505o(21378);
        return size;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(21379);
        if (i < this.mOM.size()) {
            AppMethodBeat.m2505o(21379);
            return i;
        }
        i = this.mOM.size();
        AppMethodBeat.m2505o(21379);
        return i;
    }

    /* renamed from: ws */
    public final MediaItem mo23935ws(int i) {
        AppMethodBeat.m2504i(21380);
        if (i < this.mOM.size()) {
            C4990ab.m7417i("MicroMsg.AlbumAdapter", "get header, pos[%d]", Integer.valueOf(i));
            AppMethodBeat.m2505o(21380);
            return null;
        }
        int size = i - this.mOM.size();
        MediaItem imageMediaItem;
        if (size >= this.mOH.size()) {
            C4990ab.m7421w("MicroMsg.AlbumAdapter", "get item error, media items size[%d], adjustPos[%d]", Integer.valueOf(this.mOH.size()), Integer.valueOf(size));
            imageMediaItem = new ImageMediaItem();
            imageMediaItem.mOl = C5046bo.anU();
            AppMethodBeat.m2505o(21380);
            return imageMediaItem;
        }
        imageMediaItem = (MediaItem) this.mOH.get(size);
        AppMethodBeat.m2505o(21380);
        return imageMediaItem;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(21381);
        if (i < this.mOM.size()) {
            C4990ab.m7417i("MicroMsg.AlbumAdapter", "position[%d], get header view", Integer.valueOf(i));
            View view2 = ((C12095a) this.mOM.get(i)).getView();
            AppMethodBeat.m2505o(21381);
            return view2;
        }
        String str;
        View inflate;
        C12091d c12091d;
        int size = i - this.mOM.size();
        MediaItem mediaItem = (MediaItem) this.mOH.get(size);
        if (view == null || !(view.getTag() instanceof C12091d)) {
            String str2 = "MicroMsg.AlbumAdapter";
            str = "converview is null?[%B]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(view == null);
            C4990ab.m7411d(str2, str, objArr);
            inflate = LayoutInflater.from(this.mContext).inflate(2130970555, viewGroup, false);
            C12091d c12091d2 = new C12091d();
            c12091d2.mOW = (ImageView) inflate.findViewById(2131826569);
            c12091d2.mOX = (ImageView) inflate.findViewById(2131822355);
            c12091d2.mOY = (RelativeLayout) inflate.findViewById(2131825005);
            c12091d2.mOZ = (TextView) inflate.findViewById(2131826565);
            c12091d2.moo = (CheckBox) inflate.findViewById(2131823909);
            c12091d2.mPa = (TextView) inflate.findViewById(2131827238);
            c12091d2.mop = inflate.findViewById(2131823910);
            c12091d2.mPb = (ImageView) inflate.findViewById(2131826568);
            c12091d2.mop.setOnClickListener(this.mOP);
            c12091d2.mop.setTag(2131823909, c12091d2.moo);
            c12091d2.mop.setTag(2131827238, c12091d2.mPa);
            c12091d2.mop.setTag(2131826568, c12091d2.mPb);
            if (C34237e.bBZ().hOZ == 0 || C34237e.bBZ().hOZ == 5 || C34237e.bBZ().hOZ == 10 || C34237e.bBZ().hOZ == 11 || C34237e.bBZ().hOZ == 14) {
                c12091d2.moo.setVisibility(8);
                c12091d2.mPa.setVisibility(8);
                c12091d2.mop.setVisibility(8);
                c12091d2.mPb.setVisibility(8);
            }
            c12091d2.mPc = (ImageView) inflate.findViewById(2131826566);
            c12091d2.mPd = (ImageView) inflate.findViewById(2131826567);
            inflate.setTag(c12091d2);
            c12091d = c12091d2;
        } else {
            c12091d = (C12091d) view.getTag();
            inflate = view;
        }
        if (mediaItem == null) {
            C4990ab.m7412e("MicroMsg.AlbumAdapter", "get item failed");
            AppMethodBeat.m2505o(21381);
            return inflate;
        }
        c12091d.mOW.setVisibility(0);
        if (mediaItem.getType() == 2) {
            c12091d.mOY.setVisibility(0);
            C12096c.m20022a(c12091d.mOZ, (VideoMediaItem) mediaItem);
        } else {
            c12091d.mOY.setVisibility(8);
        }
        if (mediaItem.mMimeType.equalsIgnoreCase("edit")) {
            c12091d.mPd.setVisibility(0);
        } else {
            c12091d.mPd.setVisibility(8);
        }
        str = mediaItem.mo7504Wy();
        String str3 = mediaItem.fPT;
        if (C5046bo.isNullOrNil(str) && C5046bo.isNullOrNil(str3)) {
            C4990ab.m7412e("MicroMsg.AlbumAdapter", "null or nil filepath: ".concat(String.valueOf(size)));
            AppMethodBeat.m2505o(21381);
            return inflate;
        }
        c12091d.mop.setTag(2131823910, Integer.valueOf(size));
        int i2 = C25738R.string.dcm;
        if (mediaItem.getType() == 2) {
            i2 = C25738R.string.f1v;
        }
        C4990ab.m7411d("MicroMsg.AlbumAdapter", "thumbFilaPath: %s | origFilePath: %s | contentDescription %s", str, str3, viewGroup.getContext().getString(i2, new Object[]{Integer.valueOf((i + 1) - this.mOM.size()), this.kIy.format(new Date(mediaItem.mOl))}));
        c12091d.mOX.setContentDescription(r2);
        final ImageView imageView = c12091d.mOW;
        C20921h.m32169a(c12091d.mOX, mediaItem.getType(), str, str3, mediaItem.mOk, -1, new C12100a() {
            public final void bCx() {
                AppMethodBeat.m2504i(21359);
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                AppMethodBeat.m2505o(21359);
            }
        });
        if (this.mON) {
            if (mediaItem.getType() == 2) {
                c12091d.moo.setVisibility(8);
                c12091d.mPa.setVisibility(8);
                c12091d.mop.setVisibility(8);
                c12091d.mPb.setVisibility(8);
            } else if (this.mOI.contains(mediaItem)) {
                c12091d.moo.setChecked(true);
                TextView textView = c12091d.mPa;
                StringBuilder stringBuilder = new StringBuilder();
                if (mediaItem == null) {
                    i2 = -1;
                } else {
                    i2 = this.mOI.indexOf(mediaItem);
                }
                textView.setText(stringBuilder.append(i2).toString());
                c12091d.mPb.setBackgroundResource(C25738R.color.f12084rr);
                c12091d.mop.setVisibility(0);
                c12091d.moo.setVisibility(0);
                c12091d.mPb.setVisibility(0);
            } else {
                c12091d.mPa.setVisibility(8);
                c12091d.moo.setChecked(false);
                c12091d.mPb.setBackgroundResource(C25738R.color.f12100sb);
                c12091d.moo.setVisibility(0);
                c12091d.mop.setVisibility(0);
                c12091d.mPb.setVisibility(0);
            }
        } else if (this.mOI.contains(mediaItem)) {
            c12091d.moo.setChecked(true);
            c12091d.mPb.setVisibility(0);
            c12091d.mPb.setBackgroundResource(C25738R.color.f12084rr);
        } else {
            c12091d.moo.setChecked(false);
            c12091d.mPa.setVisibility(8);
            c12091d.mPb.setVisibility(0);
            c12091d.mPb.setBackgroundResource(C25738R.color.f12100sb);
        }
        if ((C34237e.bBZ().hOZ == 3 || C34237e.bBZ().hOZ == 11) && mediaItem != null && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            c12091d.mPc.setVisibility(0);
        } else {
            c12091d.mPc.setVisibility(8);
        }
        AppMethodBeat.m2505o(21381);
        return inflate;
    }

    /* renamed from: tw */
    public final long mo23150tw(int i) {
        AppMethodBeat.m2504i(21382);
        if (i < this.mOM.size()) {
            C4990ab.m7411d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", Integer.valueOf(i));
            i = this.mOM.size();
        }
        C4990ab.m7419v("MicroMsg.AlbumAdapter", "getHeaderId, adjust pos[%d], date[%d] date[%s], headerID[%d]", Integer.valueOf(i), Long.valueOf(mo23935ws(i).mOl), r1, Long.valueOf(C15894a.dJg().mo28138b(new Date(mo23935ws(i).mOl))));
        AppMethodBeat.m2505o(21382);
        return C15894a.dJg().mo28138b(new Date(mo23935ws(i).mOl));
    }

    /* renamed from: wt */
    public final String mo23936wt(int i) {
        AppMethodBeat.m2504i(21383);
        if (i < this.mOM.size()) {
            C4990ab.m7411d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", Integer.valueOf(i));
            i = this.mOM.size();
        }
        MediaItem ws = mo23935ws(i);
        String a;
        if (C5046bo.isNullOrNil(ws.mOn)) {
            a = C15894a.dJg().mo28137a(new Date(ws.mOl), this.mContext);
            AppMethodBeat.m2505o(21383);
            return a;
        }
        a = ws.mOn;
        AppMethodBeat.m2505o(21383);
        return a;
    }

    /* renamed from: a */
    public final View mo23142a(int i, View view, ViewGroup viewGroup) {
        View textView;
        AppMethodBeat.m2504i(21384);
        if (i < this.mOM.size()) {
            C4990ab.m7411d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", Integer.valueOf(i));
            i = this.mOM.size();
        }
        if (view == null || view.getParent() != null) {
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            textView = new TextView(this.mContext);
            textView.setBackgroundResource(C25738R.drawable.a_q);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
            textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            textView.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12018pl));
            textView.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9936kr));
            textView.setTypeface(null, 1);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = view;
        }
        C4990ab.m7419v("MicroMsg.AlbumAdapter", "getHeaderView, adjust pos[%d], date[%d] date[%s], headerStr[%s]", Integer.valueOf(i), Long.valueOf(r0.mOl), new Date(mo23935ws(i).mOl), C15894a.dJg().mo28137a(new Date(mo23935ws(i).mOl), this.mContext));
        ((TextView) textView).setText(r3);
        AppMethodBeat.m2505o(21384);
        return textView;
    }
}
