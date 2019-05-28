package com.tencent.p177mm.plugin.gallery.p427ui;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C25784s;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p1380j.C41942b;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.modelgeo.C42205a;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.DrawedCallBackFrameLayout;
import com.tencent.p177mm.p612ui.base.DrawedCallBackFrameLayout.C23579a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.gallery.model.C34237e;
import com.tencent.p177mm.plugin.gallery.model.C43143i.C43142c;
import com.tencent.p177mm.plugin.gallery.model.C43143i.C43144b;
import com.tencent.p177mm.plugin.gallery.model.C45980l;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.p177mm.plugin.gallery.p427ui.C12092a.C12094b;
import com.tencent.p177mm.plugin.gallery.p427ui.C12092a.C12095a;
import com.tencent.p177mm.plugin.gallery.p427ui.ImageFolderMgrView.C43145a;
import com.tencent.p177mm.plugin.gallery.stub.C34241a;
import com.tencent.p177mm.plugin.gallery.stub.C34241a.C34242a;
import com.tencent.p177mm.plugin.gallery.stub.GalleryStubService;
import com.tencent.p177mm.plugin.mmsight.SightCaptureResult;
import com.tencent.p177mm.plugin.mmsight.SightParams;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C29970o;
import com.tencent.p177mm.pluginsdk.p597ui.p1509c.C35855a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI */
public class AlbumPreviewUI extends MMActivity implements C43142c {
    static long start = 0;
    private String cEV;
    private ProgressDialog ehJ;
    private int ehv;
    private int gLP;
    private ServiceConnection ktl = new C120831();
    private boolean kvs = false;
    private double latitude;
    private double longitude;
    private C34241a mOG = null;
    private String mOL;
    private int mPA;
    private int mPB;
    boolean mPC = false;
    private int mPD = 0;
    private int mPE = 0;
    private long mPF = 0;
    private long mPG;
    private int mPH = -1;
    private String mPI;
    private C43144b mPJ;
    private long mPK = -1;
    private C12095a mPL = new C391648();
    private boolean mPM = false;
    private HashMap<String, Integer> mPN = new HashMap();
    private GridView mPe;
    private TextView mPf;
    private boolean mPg;
    private boolean mPh;
    private TextView mPi;
    private C12092a mPj;
    private TextView mPk;
    private TextView mPl;
    private TextView mPm;
    private ImageFolderMgrView mPn;
    private TextView mPo;
    private ImageButton mPp;
    private String mPq;
    private String mPr;
    private int mPs;
    private String mPt;
    private boolean mPu = false;
    private boolean mPv = false;
    private boolean mPw = false;
    private boolean mPx = false;
    private boolean mPy = false;
    private boolean mPz = false;
    private String toUser;

    /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$17 */
    class C320917 implements C43145a {
        C320917() {
        }

        /* renamed from: b */
        public final void mo7517b(AlbumItem albumItem) {
            AppMethodBeat.m2504i(21412);
            AlbumPreviewUI.m66664a(AlbumPreviewUI.this, albumItem);
            AppMethodBeat.m2505o(21412);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$15 */
    class C1208115 implements OnClickListener {
        C1208115() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21410);
            AlbumPreviewUI.this.mPg = true;
            Intent intent = new Intent(AlbumPreviewUI.this, ImagePreviewUI.class);
            C34237e.m56155B(AlbumPreviewUI.this.mPj.mOH);
            intent.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.this.mPj.bCw());
            intent.putExtra("max_select_count", AlbumPreviewUI.this.mPA);
            intent.putExtra("send_raw_img", AlbumPreviewUI.this.kvs);
            intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.cEV);
            intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
            AlbumPreviewUI.this.startActivityForResult(intent, 0);
            AppMethodBeat.m2505o(21410);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$18 */
    class C1208218 implements OnClickListener {
        C1208218() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21413);
            AlbumPreviewUI.m66695x(AlbumPreviewUI.this);
            AlbumPreviewUI.this.mPn.bCE();
            C4990ab.m7411d("MicroMsg.AlbumPreviewUI", "click folder times[%d]", Integer.valueOf(AlbumPreviewUI.this.mPE));
            AppMethodBeat.m2505o(21413);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$1 */
    class C120831 implements ServiceConnection {
        C120831() {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.m2504i(21386);
            C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "onServiceConnected");
            AlbumPreviewUI.this.mOG = C34242a.m56168B(iBinder);
            if (AlbumPreviewUI.this.mPj != null) {
                AlbumPreviewUI.this.mPj.mOG = AlbumPreviewUI.this.mOG;
            }
            AppMethodBeat.m2505o(21386);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.m2504i(21387);
            C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "onServiceDisconnected");
            AlbumPreviewUI.this.mOG = null;
            AppMethodBeat.m2505o(21387);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$3 */
    class C120843 implements C12094b {
        C120843() {
        }

        /* renamed from: W */
        public final void mo23918W(int i, int i2, int i3) {
            AppMethodBeat.m2504i(21390);
            MediaItem ws = AlbumPreviewUI.this.mPj.mo23935ws(AlbumPreviewUI.this.mPj.mOM.size() + i2);
            if (i3 != 0) {
                AlbumPreviewUI.m66669b(AlbumPreviewUI.this, i);
                AlbumPreviewUI.this.mo62068V(i2, false);
            } else if (ws != null && ws.getType() == 1) {
                AlbumPreviewUI.m66665a(AlbumPreviewUI.this, ws);
                AlbumPreviewUI.m66669b(AlbumPreviewUI.this, i);
                AlbumPreviewUI.this.mo62068V(i2, true);
            } else if (ws == null || ws.getType() != 2) {
                AlbumPreviewUI.m66669b(AlbumPreviewUI.this, i);
                AlbumPreviewUI.this.mo62068V(i2, true);
            } else if (AlbumPreviewUI.m66670b(AlbumPreviewUI.this, ws)) {
                AlbumPreviewUI.m66669b(AlbumPreviewUI.this, i);
                AlbumPreviewUI.this.mo62068V(i2, true);
            } else {
                AlbumPreviewUI.this.mPj.mOI.remove(ws);
                AlbumPreviewUI.this.mPj.notifyDataSetChanged();
            }
            Iterator it = AlbumPreviewUI.this.mPj.bCw().iterator();
            while (it.hasNext()) {
                if (!C5063r.amo((String) it.next())) {
                    AppMethodBeat.m2505o(21390);
                    return;
                }
            }
            AlbumPreviewUI.this.kvs = true;
            AppMethodBeat.m2505o(21390);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$16 */
    class C2816116 implements OnMenuItemClickListener {
        C2816116() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            boolean z = false;
            AppMethodBeat.m2504i(21411);
            C4990ab.m7411d("MicroMsg.AlbumPreviewUI", "send image, previewImageCount:%d, chooseForTimeline:%b", Integer.valueOf(C34237e.bCg()), Boolean.valueOf(AlbumPreviewUI.this.mPu));
            try {
                AlbumPreviewUI.this.mOG.mo36247aK(11610, (AlbumPreviewUI.this.mPu ? 3 : 2) + "," + C34237e.bCg());
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AlbumPreviewUI", "report error, %s", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
            }
            if (AlbumPreviewUI.this.mPH < 0) {
                try {
                    AlbumPreviewUI.this.mPH = AlbumPreviewUI.this.mOG.mo36245Nd();
                } catch (Exception e2) {
                    AlbumPreviewUI.this.mPH = 26214400;
                    C4990ab.m7413e("MicroMsg.AlbumPreviewUI", "getMaxSendVideoSize error, %s", e2.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", e2, "", new Object[0]);
                }
            }
            C34237e.bCf();
            if (AlbumPreviewUI.this.mPj.bCw().size() == 0) {
                C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "onMenuItemClick");
                AlbumPreviewUI.this.setResult(-2);
                AlbumPreviewUI.this.finish();
                AppMethodBeat.m2505o(21411);
            } else {
                Intent intent = new Intent();
                int i = C34237e.bBZ().mOu;
                if (AlbumPreviewUI.this.mPu) {
                    i = 1;
                }
                if (AlbumPreviewUI.this.mPy) {
                    i = 1;
                }
                ArrayList arrayList;
                MediaItem mediaItem;
                ArrayList arrayList2;
                ArrayList arrayList3;
                Iterator it;
                if (i == 1) {
                    String str = "CropImage_Compress_Img";
                    boolean z2 = AlbumPreviewUI.this.mPu ? true : !AlbumPreviewUI.this.kvs;
                    intent.putExtra(str, z2);
                    arrayList = AlbumPreviewUI.this.mPj.mOI;
                    ArrayList arrayList4 = new ArrayList();
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        mediaItem = (MediaItem) it2.next();
                        if (!mediaItem.mMimeType.equals("edit") || C5046bo.isNullOrNil(mediaItem.mOj)) {
                            arrayList4.add(mediaItem.fPT);
                        } else {
                            arrayList4.add(mediaItem.mOj);
                        }
                    }
                    intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList4);
                    intent.putExtra("KSelectImgUseTime", System.currentTimeMillis() - AlbumPreviewUI.this.mPG);
                    AlbumPreviewUI.this.mPG = 0;
                    AlbumPreviewUI.this.setResult(-1, intent);
                    AlbumPreviewUI.this.mPv = true;
                    if (C5046bo.isNullOrNil(AlbumPreviewUI.this.cEV) || "medianote".equals(AlbumPreviewUI.this.toUser)) {
                        AlbumPreviewUI.this.finish();
                    } else if (C5046bo.m7588yz() - AlbumPreviewUI.this.mPF < 1000) {
                        C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
                        AppMethodBeat.m2505o(21411);
                    } else {
                        C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                        AlbumPreviewUI.this.mPF = C5046bo.m7588yz();
                        intent.setClassName(AlbumPreviewUI.this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
                        intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.cEV);
                        intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
                        AlbumPreviewUI.this.startActivityForResult(intent, 4373);
                    }
                } else if (i == 2) {
                    C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "onMenuItemClick video");
                    if (AlbumPreviewUI.this.getIntent().getBooleanExtra("GalleryUI_SkipVideoSizeLimit", false)) {
                        i = 0;
                    } else {
                        C35855a ajK = C35855a.ajK((String) AlbumPreviewUI.this.mPj.bCw().get(0));
                        ajK.mSize = AlbumPreviewUI.this.mPH;
                        i = ajK.aAa();
                    }
                    if (i == 0) {
                        intent.setData(Uri.fromFile(new File((String) AlbumPreviewUI.this.mPj.bCw().get(0))));
                        intent.putStringArrayListExtra("key_select_video_list", AlbumPreviewUI.this.mPj.bCw());
                        AlbumPreviewUI.this.setResult(-1, intent);
                        AlbumPreviewUI.this.mPv = true;
                        AlbumPreviewUI.this.finish();
                    } else if (i == 2) {
                        AlbumPreviewUI.m66688s(AlbumPreviewUI.this);
                        AppMethodBeat.m2505o(21411);
                    } else {
                        AlbumPreviewUI.m66689t(AlbumPreviewUI.this);
                        AppMethodBeat.m2505o(21411);
                    }
                } else if (i != 3) {
                    C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "onMenuItemClick default");
                    AlbumPreviewUI.this.setResult(-2);
                    AlbumPreviewUI.this.finish();
                } else if (!C5046bo.isNullOrNil(AlbumPreviewUI.this.mOL) && AlbumPreviewUI.this.mOL.equals("album_business_bubble_media_by_coordinate")) {
                    arrayList = AlbumPreviewUI.this.mPj.mOI;
                    arrayList2 = new ArrayList();
                    arrayList3 = new ArrayList();
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        mediaItem = (MediaItem) it.next();
                        if (mediaItem.getType() == 1) {
                            if (!mediaItem.mMimeType.equals("edit") || C5046bo.isNullOrNil(mediaItem.mOj)) {
                                arrayList3.add(mediaItem.fPT);
                            } else {
                                arrayList3.add(mediaItem.mOj);
                            }
                        } else if (mediaItem.getType() == 2) {
                            arrayList2.add(mediaItem.fPT);
                        }
                    }
                    intent.putExtra("CropImage_Compress_Img", false);
                    intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList3);
                    intent.putStringArrayListExtra("key_select_video_list", arrayList2);
                    intent.putExtra("KSelectImgUseTime", System.currentTimeMillis() - AlbumPreviewUI.this.mPG);
                    intent.putExtra("longitude", AlbumPreviewUI.this.longitude);
                    intent.putExtra("latitude", AlbumPreviewUI.this.latitude);
                    AlbumPreviewUI.this.mPG = 0;
                    AlbumPreviewUI.this.setResult(-1, intent);
                    AlbumPreviewUI.this.finish();
                    AppMethodBeat.m2505o(21411);
                } else if (C5046bo.m7588yz() - AlbumPreviewUI.this.mPF < 1000) {
                    C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
                    AppMethodBeat.m2505o(21411);
                } else {
                    AlbumPreviewUI.this.mPF = C5046bo.m7588yz();
                    arrayList = AlbumPreviewUI.this.mPj.mOI;
                    arrayList2 = new ArrayList();
                    arrayList3 = new ArrayList();
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        mediaItem = (MediaItem) it.next();
                        if (mediaItem.getType() == 1) {
                            if (!mediaItem.mMimeType.equals("edit") || C5046bo.isNullOrNil(mediaItem.mOj)) {
                                arrayList3.add(mediaItem.fPT);
                            } else {
                                arrayList3.add(mediaItem.mOj);
                            }
                        } else if (mediaItem.getType() == 2) {
                            arrayList2.add(mediaItem.fPT);
                        }
                    }
                    String str2 = "CropImage_Compress_Img";
                    if (AlbumPreviewUI.this.mPu) {
                        z = true;
                    } else if (!AlbumPreviewUI.this.kvs) {
                        z = true;
                    }
                    intent.putExtra(str2, z);
                    intent.putStringArrayListExtra("key_select_video_list", arrayList2);
                    intent.putExtra("KSelectImgUseTime", System.currentTimeMillis() - AlbumPreviewUI.this.mPG);
                    AlbumPreviewUI.this.mPG = 0;
                    if (arrayList3.size() > 0) {
                        intent.setClassName(AlbumPreviewUI.this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
                        intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList3);
                        intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.cEV);
                        intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
                        intent.putExtra("CropImage_limit_Img_Size", 26214400);
                        C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                        AlbumPreviewUI.this.startActivityForResult(intent, 4373);
                    } else {
                        C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "QueryTypeImageAndVideo");
                        AlbumPreviewUI.this.setResult(-1, intent);
                        AlbumPreviewUI.this.finish();
                    }
                }
                AppMethodBeat.m2505o(21411);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$2 */
    class C281622 implements OnItemClickListener {
        C281622() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
            AppMethodBeat.m2504i(21389);
            final MediaItem ws = AlbumPreviewUI.this.mPj.mo23935ws(i);
            String str;
            Intent intent;
            Intent intent2;
            ArrayList wr;
            AlbumPreviewUI albumPreviewUI;
            if (ws == null || C5046bo.isNullOrNil(ws.fPT)) {
                str = "MicroMsg.AlbumPreviewUI";
                String str2 = "item is null %s, item original path is null";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(ws == null);
                C4990ab.m7421w(str, str2, objArr);
                AppMethodBeat.m2505o(21389);
            } else if (C34237e.bBZ().hOZ == 0 || C34237e.bBZ().hOZ == 5 || C34237e.bBZ().hOZ == 10 || C34237e.bBZ().hOZ == 11) {
                if (C34237e.bBZ().mOu == 2) {
                    C30379h.m48453a(AlbumPreviewUI.this, true, AlbumPreviewUI.this.getString(C25738R.string.c4a), "", AlbumPreviewUI.this.getString(C25738R.string.f9221tf), AlbumPreviewUI.this.getString(C25738R.string.f9076or), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(21388);
                            if (ws == null) {
                                C4990ab.m7421w("MicroMsg.AlbumPreviewUI", "get item for video error, null, position %d", Integer.valueOf(i));
                                AlbumPreviewUI.this.setResult(0);
                            } else {
                                C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "ShowAlert");
                                Intent intent = new Intent();
                                intent.setData(Uri.parse("file://" + Uri.encode(ws.fPT)));
                                AlbumPreviewUI.this.setResult(-1, intent);
                            }
                            AlbumPreviewUI.this.finish();
                            AppMethodBeat.m2505o(21388);
                        }
                    }, null);
                    AppMethodBeat.m2505o(21389);
                    return;
                }
                if (ws == null) {
                    C4990ab.m7421w("MicroMsg.AlbumPreviewUI", "get item error, null, position %d", Integer.valueOf(i));
                    AlbumPreviewUI.this.setResult(0);
                } else {
                    intent = new Intent();
                    if (ws.getType() == 2) {
                        intent.putExtra("is_video", true);
                        intent.putExtra("video_full_path", ws.fPT);
                    }
                    if (C34237e.bBZ().hOZ == 10) {
                        intent.putExtra("CropImage_OutputPath", ws.fPT);
                    }
                    intent.setData(Uri.parse(Uri.encode(ws.fPT)));
                    C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "getItem ok");
                    AlbumPreviewUI.this.setResult(-1, intent);
                }
                AlbumPreviewUI.this.finish();
                AppMethodBeat.m2505o(21389);
            } else if (C34237e.bBZ().hOZ != 4) {
                if (C34237e.bBZ().hOZ == 14) {
                    if (i < AlbumPreviewUI.this.mPj.mOM.size()) {
                        C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
                        AppMethodBeat.m2505o(21389);
                        return;
                    } else if (ws == null) {
                        C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!! MediaItem == null.");
                        AppMethodBeat.m2505o(21389);
                        return;
                    } else if (ws.getType() == 2 && AlbumPreviewUI.this.mPj.mOI.size() != 0) {
                        C30379h.m48465bQ(AlbumPreviewUI.this.mController.ylL, C1338a.m2858an(AlbumPreviewUI.this.mController.ylL, C25738R.string.c3b));
                        AppMethodBeat.m2505o(21389);
                        return;
                    } else if (ws instanceof VideoMediaItem) {
                        VideoMediaItem videoMediaItem = (VideoMediaItem) ws;
                        int i2 = videoMediaItem.eXL;
                        if (i2 == 0 || i2 == 180) {
                            if (videoMediaItem.videoWidth >= videoMediaItem.videoHeight) {
                                C4990ab.m7417i("MicroMsg.AlbumPreviewUI", "select story video, video ratio error, width:%s, height:%s, rotate:%s", Integer.valueOf(videoMediaItem.videoWidth), Integer.valueOf(videoMediaItem.videoHeight), Integer.valueOf(i2));
                                C7060h.pYm.mo15419k(1005, 52, 1);
                                C30379h.m48465bQ(AlbumPreviewUI.this.mController.ylL, C1338a.m2858an(AlbumPreviewUI.this.mController.ylL, C25738R.string.c3o));
                                AppMethodBeat.m2505o(21389);
                                return;
                            }
                        } else if ((i2 == 270 || i2 == 90) && videoMediaItem.videoHeight >= videoMediaItem.videoWidth) {
                            C4990ab.m7417i("MicroMsg.AlbumPreviewUI", "select story video, video ratio error, width:%s, height:%s, rotate:%s", Integer.valueOf(videoMediaItem.videoWidth), Integer.valueOf(videoMediaItem.videoHeight), Integer.valueOf(i2));
                            C7060h.pYm.mo15419k(1005, 52, 1);
                            C30379h.m48465bQ(AlbumPreviewUI.this.mController.ylL, C1338a.m2858an(AlbumPreviewUI.this.mController.ylL, C25738R.string.c3o));
                            AppMethodBeat.m2505o(21389);
                            return;
                        }
                        if (videoMediaItem.fPW <= 2000) {
                            C4990ab.m7417i("MicroMsg.AlbumPreviewUI", "select story video, duration too long, duration:%s", Integer.valueOf(videoMediaItem.fPW));
                            C7060h.pYm.mo15419k(1005, 53, 1);
                            C30379h.m48465bQ(AlbumPreviewUI.this.mController.ylL, C1338a.m2858an(AlbumPreviewUI.this.mController.ylL, C25738R.string.c3u));
                            AppMethodBeat.m2505o(21389);
                            return;
                        }
                        if (videoMediaItem.videoFrameRate <= 1 && videoMediaItem.videoFrameRate >= 0) {
                            C4990ab.m7417i("MicroMsg.AlbumPreviewUI", "select story video, videoFrameRate too small:%s, videoPath:%s", Integer.valueOf(videoMediaItem.videoFrameRate), videoMediaItem.fPT);
                            if (videoMediaItem.videoFrameRate == 1) {
                                try {
                                    str = SightVideoJNI.getSimpleMp4Info(videoMediaItem.fPT);
                                    if (!C5046bo.isNullOrNil(str)) {
                                        double optDouble = new JSONObject(str).optDouble("videoFPS");
                                        C4990ab.m7417i("MicroMsg.AlbumPreviewUI", "update from getSimpleMp4Info videoFPS:%s", Double.valueOf(optDouble));
                                        if (optDouble > 0.0d) {
                                            videoMediaItem.videoFrameRate = (int) optDouble;
                                        }
                                    }
                                } catch (Exception e) {
                                }
                            }
                            if (videoMediaItem.videoFrameRate <= 0) {
                                C4990ab.m7417i("MicroMsg.AlbumPreviewUI", "final videoFrameRate:%s, too small, videoPath:%s", Integer.valueOf(videoMediaItem.videoFrameRate), videoMediaItem.fPT);
                                C7060h.pYm.mo15419k(1005, 54, 1);
                                C30379h.m48465bQ(AlbumPreviewUI.this.mController.ylL, C1338a.m2858an(AlbumPreviewUI.this.mController.ylL, C25738R.string.c3m));
                                AppMethodBeat.m2505o(21389);
                                return;
                            }
                        }
                        if (videoMediaItem.fPW >= 10500) {
                            intent2 = new Intent();
                            intent2.putExtra("key_video_path", videoMediaItem.fPT);
                            intent2.putExtra("key_need_clip_video_first", true);
                            intent2.putExtra("key_need_remux_video", false);
                            intent2.putExtra("key_text_color", AlbumPreviewUI.this.getIntent().getStringExtra("key_edit_text_color"));
                            intent2.putExtra("key_max_duration_seconds", AlbumPreviewUI.this.getIntent().getIntExtra("key_edit_video_max_time_length", 10));
                            C25985d.m41468b(AlbumPreviewUI.this.mController.ylL, "mmsight", ".segment.MMSightEditUI", intent2, 4374);
                            AppMethodBeat.m2505o(21389);
                            return;
                        }
                        intent2 = new Intent();
                        intent2.putExtra("K_SEGMENTVIDEOPATH", videoMediaItem.fPT);
                        intent2.putExtra("KSEGMENTVIDEOTHUMBPATH", videoMediaItem.lZg);
                        AlbumPreviewUI.this.setResult(-1, intent2);
                        AlbumPreviewUI.this.finish();
                        AppMethodBeat.m2505o(21389);
                        return;
                    }
                } else if (AlbumPreviewUI.this.mPy) {
                    if (i < AlbumPreviewUI.this.mPj.mOM.size()) {
                        C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
                        AppMethodBeat.m2505o(21389);
                        return;
                    } else if (ws == null) {
                        C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!! MediaItem == null.");
                        AppMethodBeat.m2505o(21389);
                        return;
                    } else if (ws.getType() != 2 || AlbumPreviewUI.this.mPj.mOI.size() == 0) {
                        wr = AlbumPreviewUI.this.mPj.mo23934wr(ws.getType());
                        C34237e.m56155B(wr);
                        intent2 = new Intent(AlbumPreviewUI.this, ImagePreviewUI.class);
                        intent2.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.this.mPj.bCw());
                        intent2.putExtra("preview_all", true);
                        intent2.putExtra("preview_position", wr.indexOf(ws));
                        albumPreviewUI = AlbumPreviewUI.this;
                        albumPreviewUI.mo62068V(i - albumPreviewUI.mPj.mOM.size(), true);
                        intent2.putExtra("send_raw_img", AlbumPreviewUI.this.kvs);
                        intent2.putExtra("max_select_count", ws.getType() == 2 ? 1 : AlbumPreviewUI.this.mPA);
                        intent2.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.cEV);
                        intent2.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
                        AlbumPreviewUI.this.startActivityForResult(intent2, 0);
                        AppMethodBeat.m2505o(21389);
                        return;
                    } else {
                        C30379h.m48465bQ(AlbumPreviewUI.this.mController.ylL, C1338a.m2858an(AlbumPreviewUI.this.mController.ylL, C25738R.string.c3b));
                        AppMethodBeat.m2505o(21389);
                        return;
                    }
                } else if (i < AlbumPreviewUI.this.mPj.mOM.size()) {
                    C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
                    AppMethodBeat.m2505o(21389);
                    return;
                } else {
                    C34237e.m56155B(AlbumPreviewUI.this.mPj.mOH);
                    intent = new Intent(AlbumPreviewUI.this, ImagePreviewUI.class);
                    intent.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.this.mPj.bCw());
                    intent.putExtra("preview_all", true);
                    intent.putExtra("preview_position", i - AlbumPreviewUI.this.mPj.mOM.size());
                    AlbumPreviewUI albumPreviewUI2 = AlbumPreviewUI.this;
                    albumPreviewUI2.mo62068V(i - albumPreviewUI2.mPj.mOM.size(), true);
                    intent.putExtra("send_raw_img", AlbumPreviewUI.this.kvs);
                    intent.putExtra("max_select_count", AlbumPreviewUI.this.mPA);
                    intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.cEV);
                    intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
                    intent.putExtra("album_business_tag", AlbumPreviewUI.this.mOL);
                    intent.putExtra("album_video_max_duration", AlbumPreviewUI.this.gLP);
                    AlbumPreviewUI.this.startActivityForResult(intent, 0);
                }
                AppMethodBeat.m2505o(21389);
            } else if (i < AlbumPreviewUI.this.mPj.mOM.size()) {
                C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
                AppMethodBeat.m2505o(21389);
            } else if (ws == null) {
                C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!! MediaItem == null.");
                AppMethodBeat.m2505o(21389);
            } else if (ws.getType() != 2 || AlbumPreviewUI.this.mPj.mOI.size() == 0) {
                wr = AlbumPreviewUI.this.mPj.mo23934wr(ws.getType());
                C34237e.m56155B(wr);
                intent2 = new Intent(AlbumPreviewUI.this, ImagePreviewUI.class);
                intent2.putExtra("key_edit_video_max_time_length", AlbumPreviewUI.this.getIntent().getIntExtra("key_edit_video_max_time_length", 10));
                intent2.putExtra("key_edit_text_color", AlbumPreviewUI.this.getIntent().getStringExtra("key_edit_text_color"));
                intent2.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.this.mPj.bCw());
                intent2.putExtra("preview_all", true);
                intent2.putExtra("preview_position", wr.indexOf(ws));
                albumPreviewUI = AlbumPreviewUI.this;
                albumPreviewUI.mo62068V(i - albumPreviewUI.mPj.mOM.size(), true);
                intent2.putExtra("send_raw_img", AlbumPreviewUI.this.kvs);
                intent2.putExtra("max_select_count", AlbumPreviewUI.this.mPA);
                intent2.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.cEV);
                intent2.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
                AlbumPreviewUI.this.startActivityForResult(intent2, 0);
                AppMethodBeat.m2505o(21389);
            } else {
                C30379h.m48465bQ(AlbumPreviewUI.this.mController.ylL, C1338a.m2858an(AlbumPreviewUI.this.mController.ylL, C25738R.string.c3b));
                AppMethodBeat.m2505o(21389);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$9 */
    class C281679 implements AnimationListener {
        private Runnable mPU = new C281661();

        /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$9$1 */
        class C281661 implements Runnable {
            C281661() {
            }

            public final void run() {
                AppMethodBeat.m2504i(21404);
                AlbumPreviewUI.this.mPm.startAnimation(AnimationUtils.loadAnimation(AlbumPreviewUI.this.mController.ylL, C25738R.anim.f8333b6));
                AlbumPreviewUI.this.mPm.setVisibility(8);
                AppMethodBeat.m2505o(21404);
            }
        }

        C281679() {
            AppMethodBeat.m2504i(21405);
            AppMethodBeat.m2505o(21405);
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(21406);
            AlbumPreviewUI.this.mPm.setVisibility(0);
            AlbumPreviewUI.this.mPm.postDelayed(this.mPU, 4000);
            AppMethodBeat.m2505o(21406);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$10 */
    class C3916010 implements DialogInterface.OnClickListener {
        C3916010() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(21407);
            AlbumPreviewUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(21407);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$11 */
    class C3916111 implements OnCancelListener {
        C3916111() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$13 */
    class C3916213 implements OnClickListener {
        C3916213() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21408);
            AlbumPreviewUI.this.mPp.performClick();
            AppMethodBeat.m2505o(21408);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$6 */
    class C391636 implements OnMenuItemClickListener {
        C391636() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(21398);
            C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "backBtn");
            AlbumPreviewUI.this.setResult(-2);
            if (AlbumPreviewUI.this.mPn.aej) {
                AlbumPreviewUI.this.mPn.bCE();
                AppMethodBeat.m2505o(21398);
            } else {
                AlbumPreviewUI.this.finish();
                AppMethodBeat.m2505o(21398);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$8 */
    class C391648 implements C12095a {
        private OnClickListener mjE = new C281651();

        /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$8$1 */
        class C281651 implements OnClickListener {
            C281651() {
            }

            private void bCD() {
                AppMethodBeat.m2504i(21400);
                String stringExtra = AlbumPreviewUI.this.getIntent().getStringExtra("to_user");
                String stringExtra2 = AlbumPreviewUI.this.getIntent().getStringExtra("file_name");
                String stringExtra3 = AlbumPreviewUI.this.getIntent().getStringExtra("video_path");
                String stringExtra4 = AlbumPreviewUI.this.getIntent().getStringExtra("video_full_path");
                String stringExtra5 = AlbumPreviewUI.this.getIntent().getStringExtra("video_thumb_path");
                try {
                    Intent intent = new Intent();
                    intent.setClassName(AlbumPreviewUI.this.mController.ylL.getPackageName(), "com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI");
                    intent.putExtra("VideoRecorder_ToUser", stringExtra);
                    intent.putExtra("VideoRecorder_FileName", stringExtra2);
                    intent.putExtra("VideoRecorder_VideoPath", stringExtra3);
                    intent.putExtra("VideoRecorder_VideoFullPath", stringExtra4);
                    intent.putExtra("VideoRecorder_VideoThumbPath", stringExtra5);
                    C4990ab.m7411d("MicroMsg.AlbumPreviewUI", "try to record video, dump intent:\n%s", intent);
                    AlbumPreviewUI.this.startActivityForResult(intent, 4371);
                    AppMethodBeat.m2505o(21400);
                } catch (Exception e) {
                    C4990ab.m7420w("MicroMsg.AlbumPreviewUI", e.toString());
                    if (!(C35973a.m59178bI(AlbumPreviewUI.this.mController.ylL) || C35973a.m59177bH(AlbumPreviewUI.this.mController.ylL))) {
                        C41942b.m74077s(AlbumPreviewUI.this.mController.ylL);
                    }
                    AppMethodBeat.m2505o(21400);
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(21401);
                C4990ab.m7411d("MicroMsg.AlbumPreviewUI", "on click open camera, valid click times[%d]", Integer.valueOf(AlbumPreviewUI.this.mPD));
                if (AlbumPreviewUI.this.mPz) {
                    C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "click open camera, but camera is opening");
                    AppMethodBeat.m2505o(21401);
                    return;
                }
                AlbumPreviewUI.m66654K(AlbumPreviewUI.this);
                AlbumPreviewUI.this.mPz = true;
                if (C34237e.bBZ().mOu != 2 && C34237e.bBZ().hOZ != 13) {
                    if (C34237e.bBZ().mOu == 1 || C34237e.bBZ().mOu == 3) {
                        File file = new File(C6457e.euR);
                        if (file.exists() || file.mkdir()) {
                            C4990ab.m7417i("MicroMsg.AlbumPreviewUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(AlbumPreviewUI.this.mController.ylL, "android.permission.CAMERA", 16, "", "")), C5046bo.dpG(), AlbumPreviewUI.this.mController.ylL);
                            if (C35805b.m58707a(AlbumPreviewUI.this.mController.ylL, "android.permission.CAMERA", 16, "", "")) {
                                AlbumPreviewUI.m66656M(AlbumPreviewUI.this);
                            } else {
                                AppMethodBeat.m2505o(21401);
                                return;
                            }
                        }
                        Toast.makeText(AlbumPreviewUI.this.mController.ylL, AlbumPreviewUI.this.getString(C25738R.string.aor), 1).show();
                        AppMethodBeat.m2505o(21401);
                        return;
                    }
                    AppMethodBeat.m2505o(21401);
                } else if (AlbumPreviewUI.this.getIntent().getBooleanExtra("record_video_force_sys_camera", false)) {
                    int intExtra = AlbumPreviewUI.this.getIntent().getIntExtra("record_video_quality", 0);
                    int intExtra2 = AlbumPreviewUI.this.getIntent().getIntExtra("record_video_time_limit", 0);
                    C14987n.m23297a(AlbumPreviewUI.this.mController.ylL, AlbumPreviewUI.this.getIntent().getStringExtra("video_full_path"), 4372, intExtra2, intExtra, false);
                    AppMethodBeat.m2505o(21401);
                } else if (AlbumPreviewUI.this.getIntent().getBooleanExtra("record_video_is_sight_capture", false)) {
                    if (((SightParams) AlbumPreviewUI.this.getIntent().getParcelableExtra("KEY_SIGHT_PARAMS")) == null) {
                        C4990ab.m7412e("MicroMsg.AlbumPreviewUI", "takeMMSight, sightParams == null");
                    }
                    if (C34237e.bBZ().hOZ != 13) {
                        C14987n.m23302a(AlbumPreviewUI.this.mController.ylL, 4375, AlbumPreviewUI.this.getIntent(), 3, 1);
                        AppMethodBeat.m2505o(21401);
                        return;
                    }
                    C14987n.m23302a(AlbumPreviewUI.this.mController.ylL, 4375, AlbumPreviewUI.this.getIntent(), 4, 1);
                    AppMethodBeat.m2505o(21401);
                } else if (C1427q.etn.erY == 2) {
                    bCD();
                    AppMethodBeat.m2505o(21401);
                } else if (C1427q.etn.erY != 1 || C35973a.m59178bI(AlbumPreviewUI.this.mController.ylL) || C35973a.m59177bH(AlbumPreviewUI.this.mController.ylL)) {
                    bCD();
                    AppMethodBeat.m2505o(21401);
                } else {
                    C41942b.m74077s(AlbumPreviewUI.this.mController.ylL);
                    AppMethodBeat.m2505o(21401);
                }
            }
        }

        C391648() {
            AppMethodBeat.m2504i(21402);
            AppMethodBeat.m2505o(21402);
        }

        public final View getView() {
            AppMethodBeat.m2504i(21403);
            View inflate = View.inflate(AlbumPreviewUI.this.mController.ylL, 2130969001, null);
            inflate.setOnClickListener(this.mjE);
            TextView textView = (TextView) inflate.findViewById(2131822355);
            if (C34237e.bBZ().mOu == 2 || C34237e.bBZ().hOZ == 13) {
                textView.setText(C25738R.string.c4c);
            } else if (C34237e.bBZ().mOu == 1) {
                textView.setText(C25738R.string.c4b);
            }
            inflate.setLayerType(1, null);
            AppMethodBeat.m2505o(21403);
            return inflate;
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$a */
    static class C39166a implements Runnable {
        public WeakReference<C12092a> mPW;
        public WeakReference<ProgressDialog> mPX;
        public WeakReference<TextView> mPY;
        public WeakReference<GridView> mPZ;
        public LinkedList<MediaItem> mQa;
        public WeakReference<String> mQb;

        private C39166a() {
        }

        /* synthetic */ C39166a(byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(21415);
            String str = "MicroMsg.AlbumPreviewUI";
            String str2 = "on NotifyMediaItemsChanged, size %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(this.mQa == null ? -1 : this.mQa.size());
            C4990ab.m7411d(str, str2, objArr);
            if (this.mPW == null) {
                C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "null == adapterRef");
                AppMethodBeat.m2505o(21415);
                return;
            }
            C12092a c12092a = (C12092a) this.mPW.get();
            if (c12092a == null) {
                C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "null == adapter");
                AppMethodBeat.m2505o(21415);
                return;
            }
            AlbumPreviewUI.m66658W(this.mQa);
            LinkedList linkedList = this.mQa;
            if (c12092a.mOO) {
                c12092a.mOO = false;
                c12092a.mOH.clear();
            }
            c12092a.mOH.addAll(linkedList);
            c12092a.notifyDataSetChanged();
            if (this.mPX == null) {
                AppMethodBeat.m2505o(21415);
                return;
            }
            ProgressDialog progressDialog = (ProgressDialog) this.mPX.get();
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
                C4990ab.m7417i("MicroMsg.AlbumPreviewUI", "[NotifyMediaItemsChanged] cost:%s", Long.valueOf(System.currentTimeMillis() - AlbumPreviewUI.start));
            }
            if (this.mPY == null || this.mPZ == null || this.mQb == null) {
                AppMethodBeat.m2505o(21415);
                return;
            }
            final TextView textView = (TextView) this.mPY.get();
            GridView gridView = (GridView) this.mPZ.get();
            String str3 = (String) this.mQb.get();
            if (!(textView == null || gridView == null || str3 == null)) {
                String wt = c12092a.mo23936wt(gridView.getFirstVisiblePosition());
                if (!C5046bo.isNullOrNil(wt) && wt.equals("album_business_bubble_media_by_coordinate")) {
                    textView.setVisibility(0);
                    textView.setText(str3 + "附近的照片和视频");
                    textView.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(21414);
                            if (8 == textView.getVisibility()) {
                                AppMethodBeat.m2505o(21414);
                                return;
                            }
                            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                            alphaAnimation.setDuration(300);
                            textView.clearAnimation();
                            textView.startAnimation(alphaAnimation);
                            textView.setVisibility(8);
                            AppMethodBeat.m2505o(21414);
                        }
                    }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                }
            }
            AppMethodBeat.m2505o(21415);
        }

        public final String toString() {
            AppMethodBeat.m2504i(21416);
            String str = super.toString() + "|notifyRunnable";
            AppMethodBeat.m2505o(21416);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$12 */
    class C3916812 implements OnCancelListener {
        C3916812() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$14 */
    class C3916914 implements OnClickListener {
        C3916914() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21409);
            AlbumPreviewUI.this.kvs = !AlbumPreviewUI.this.kvs;
            AlbumPreviewUI.m66674e(AlbumPreviewUI.this);
            AlbumPreviewUI.this.mPo.setText(AlbumPreviewUI.this.mController.ylL.getString(C25738R.string.c3i) + "");
            if (AlbumPreviewUI.this.kvs) {
                AlbumPreviewUI.this.mPp.setImageResource(C1318a.radio_on);
            } else {
                AlbumPreviewUI.this.mPp.setImageResource(C1318a.radio_off);
            }
            AlbumPreviewUI.m66676g(AlbumPreviewUI.this);
            AppMethodBeat.m2505o(21409);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$5 */
    class C391705 implements OnScrollListener {
        private Runnable kvR = new C281641();

        /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$5$1 */
        class C281641 implements Runnable {
            C281641() {
            }

            public final void run() {
                AppMethodBeat.m2504i(21392);
                AlbumPreviewUI.this.mPk.startAnimation(AnimationUtils.loadAnimation(AlbumPreviewUI.this.mController.ylL, C25738R.anim.f8333b6));
                AlbumPreviewUI.this.mPk.setVisibility(8);
                AppMethodBeat.m2505o(21392);
            }
        }

        C391705() {
            AppMethodBeat.m2504i(21393);
            AppMethodBeat.m2505o(21393);
        }

        private String bCC() {
            AppMethodBeat.m2504i(21394);
            String wt = AlbumPreviewUI.this.mPj.mo23936wt(AlbumPreviewUI.this.mPe.getFirstVisiblePosition());
            if (C5046bo.isNullOrNil(wt) || !wt.equals("album_business_bubble_media_by_coordinate")) {
                AppMethodBeat.m2505o(21394);
                return wt;
            }
            wt = AlbumPreviewUI.this.mPI + "附近的照片和视频";
            AppMethodBeat.m2505o(21394);
            return wt;
        }

        /* renamed from: hD */
        private void m66701hD(boolean z) {
            AppMethodBeat.m2504i(21395);
            if (z) {
                AlbumPreviewUI.this.mPk.removeCallbacks(this.kvR);
                if (AlbumPreviewUI.this.mPk.getVisibility() != 0) {
                    AlbumPreviewUI.this.mPe.getFirstVisiblePosition();
                    AlbumPreviewUI.this.mPk.setText(bCC());
                    AlbumPreviewUI.this.mPk.clearAnimation();
                    Animation loadAnimation = AnimationUtils.loadAnimation(AlbumPreviewUI.this.mController.ylL, C25738R.anim.f8332b5);
                    AlbumPreviewUI.this.mPk.setVisibility(0);
                    AlbumPreviewUI.this.mPk.startAnimation(loadAnimation);
                    AppMethodBeat.m2505o(21395);
                    return;
                }
            }
            AlbumPreviewUI.this.mPk.removeCallbacks(this.kvR);
            AlbumPreviewUI.this.mPk.postDelayed(this.kvR, 256);
            AppMethodBeat.m2505o(21395);
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            int i2 = 0;
            AppMethodBeat.m2504i(21396);
            C4990ab.m7411d("MicroMsg.AlbumPreviewUI", "scroll state[%d]", Integer.valueOf(i));
            if (1 == i) {
                m66701hD(true);
                AlbumPreviewUI.this.mPl.setVisibility(8);
            } else if (i == 0) {
                m66701hD(false);
            }
            if (2 == i) {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, AlbumPreviewUI.this.ehv);
                AlbumPreviewUI albumPreviewUI = AlbumPreviewUI.this;
                boolean z = WXHardCoderJNI.hcAlbumScrollEnable;
                int i3 = WXHardCoderJNI.hcAlbumScrollDelay;
                int i4 = WXHardCoderJNI.hcAlbumScrollCPU;
                int i5 = WXHardCoderJNI.hcAlbumScrollIO;
                if (WXHardCoderJNI.hcAlbumScrollThr) {
                    i2 = Process.myTid();
                }
                albumPreviewUI.ehv = WXHardCoderJNI.startPerformance(z, i3, i4, i5, i2, WXHardCoderJNI.hcAlbumScrollTimeout, 702, WXHardCoderJNI.hcAlbumScrollAction, "MicroMsg.AlbumPreviewUI");
            }
            AppMethodBeat.m2505o(21396);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.m2504i(21397);
            AlbumPreviewUI.this.mPk.setText(bCC());
            AppMethodBeat.m2505o(21397);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI$7 */
    class C391717 implements C23579a {
        C391717() {
        }

        public final void bCv() {
            AppMethodBeat.m2504i(21399);
            try {
                AlbumPreviewUI.this.mOG.bCv();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
            }
            if (AlbumPreviewUI.this.mPC) {
                try {
                    AlbumPreviewUI.this.unbindService(AlbumPreviewUI.this.ktl);
                } catch (Throwable th) {
                    C4990ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", th, "Failed to unbindService when onViewDrawed is invoked.", new Object[0]);
                }
                AlbumPreviewUI.this.mPC = false;
            }
            AppMethodBeat.m2505o(21399);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public AlbumPreviewUI() {
        AppMethodBeat.m2504i(21417);
        AppMethodBeat.m2505o(21417);
    }

    /* renamed from: K */
    static /* synthetic */ int m66654K(AlbumPreviewUI albumPreviewUI) {
        int i = albumPreviewUI.mPD + 1;
        albumPreviewUI.mPD = i;
        return i;
    }

    /* renamed from: M */
    static /* synthetic */ void m66656M(AlbumPreviewUI albumPreviewUI) {
        AppMethodBeat.m2504i(21445);
        albumPreviewUI.bCz();
        AppMethodBeat.m2505o(21445);
    }

    /* renamed from: x */
    static /* synthetic */ int m66695x(AlbumPreviewUI albumPreviewUI) {
        int i = albumPreviewUI.mPE + 1;
        albumPreviewUI.mPE = i;
        return i;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(21418);
        super.onCreate(bundle);
        this.mPG = System.currentTimeMillis();
        C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "onCreate");
        if (bundle != null) {
            C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "savedInstanceState not null");
            this.mPB = bundle.getInt("constants_key");
            C34237e.bBZ().hOZ = this.mPB;
        }
        mo17372Nb(this.mController.ylL.getResources().getColor(C25738R.color.f11906l8));
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, new C3916111());
        start = System.currentTimeMillis();
        int intExtra = getIntent().getIntExtra("query_source_type", 3);
        int intExtra2 = getIntent().getIntExtra("query_media_type", 1);
        C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "query souce: " + intExtra + ", queryType: " + intExtra2);
        C34237e.bBZ().mo73865wq(intExtra2);
        C34237e.bBZ().hOZ = intExtra;
        initView();
        C34237e.bBZ().mOr.add(this);
        this.mPK = System.currentTimeMillis();
        C45980l bBZ = C34237e.bBZ();
        bBZ.mo73864g(this.mPr, bBZ.mOu, this.mPK);
        bindService(new Intent(this.mController.ylL, GalleryStubService.class), this.ktl, 1);
        C29970o.m47417JV(1);
        AppMethodBeat.m2505o(21418);
    }

    public void onPause() {
        AppMethodBeat.m2504i(21419);
        super.onPause();
        C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "on resume");
        this.mPz = true;
        C4990ab.m7410d("MicroMsg.AlbumPreviewUI", "shouldSaveLastChoosePath: " + this.mPv);
        if (this.mPv) {
            bCA();
        }
        if (this.mPn.aej) {
            ImageFolderMgrView imageFolderMgrView = this.mPn;
            if (!imageFolderMgrView.aej) {
                C4990ab.m7420w("MicroMsg.ImageFolderMgrView", "want to close, but it was closed");
            } else if (imageFolderMgrView.mQE) {
                C4990ab.m7410d("MicroMsg.ImageFolderMgrView", "want to close, but it is in animation");
            } else {
                imageFolderMgrView.mQA.setVisibility(8);
                imageFolderMgrView.aej = false;
            }
        }
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, this.ehv);
        this.ehv = 0;
        AppMethodBeat.m2505o(21419);
    }

    public void onResume() {
        AppMethodBeat.m2504i(21420);
        super.onResume();
        C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "on resume");
        this.mPz = false;
        AppMethodBeat.m2505o(21420);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(21421);
        super.onDestroy();
        C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "onDestroy");
        C34237e.bBZ().mo73862b(this.mPn);
        C34237e.bCa().bCp();
        C34237e.bCa().bCo().removeCallbacksAndMessages(null);
        C34237e.bBZ().mOr.remove(this);
        C45980l bBZ = C34237e.bBZ();
        C43144b c43144b = this.mPJ;
        if (c43144b != null) {
            bBZ.mOs.remove(c43144b);
        }
        if (this.mPD > 0 || this.mPE > 0) {
            C4990ab.m7411d("MicroMsg.AlbumPreviewUI", "report click camera count[%d], click folder count[%d]", Integer.valueOf(this.mPD), Integer.valueOf(this.mPE));
            try {
                this.mOG.mo36247aK(11187, this.mPD + "," + this.mPE);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AlbumPreviewUI", "report error, %s", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
            }
        } else {
            C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "do not click camera or folder!");
        }
        try {
            boolean z;
            if (this.mPF > 0 || this.mPh) {
                C34237e.m56158a(this.mOG, this.mPt, AlbumPreviewUI.m66647D(this.mPj.mOI), this.kvs, this.mPg);
            }
            C34241a c34241a = this.mOG;
            int size = this.mPj.mOI.size();
            boolean z2 = this.kvs;
            if (this.mPF > 0 || this.mPh) {
                z = true;
            } else {
                z = false;
            }
            C34237e.m56157a(c34241a, size, z2, z);
        } catch (RemoteException e2) {
            C4990ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", e2, "", new Object[0]);
        }
        C25784s.ccQ.mo33296Ae().mo33291Ad();
        C34237e.bCc().clear();
        C34237e.bCd().clear();
        C34237e.bCe().clear();
        try {
            unbindService(this.ktl);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", th, "Failed to unbindService when Activity.onDestroy is invoked.", new Object[0]);
        }
        C29970o.m47417JV(2);
        C34237e.bBY().mo68660b(null);
        AppMethodBeat.m2505o(21421);
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(21422);
        this.mPB = C34237e.bBZ().hOZ;
        bundle.putInt("constants_key", this.mPB);
        AppMethodBeat.m2505o(21422);
    }

    public final int getLayoutId() {
        return 2130970554;
    }

    private void updateTitle() {
        AppMethodBeat.m2504i(21423);
        if (C34237e.bBZ().mOu == 3) {
            setMMTitle((int) C25738R.string.c34);
            this.mPi.setText(C25738R.string.c34);
            AppMethodBeat.m2505o(21423);
        } else if (C34237e.bBZ().mOu == 1) {
            setMMTitle((int) C25738R.string.c48);
            this.mPi.setText(C25738R.string.c33);
            AppMethodBeat.m2505o(21423);
        } else {
            setMMTitle((int) C25738R.string.c35);
            this.mPi.setText(C25738R.string.c35);
            AppMethodBeat.m2505o(21423);
        }
    }

    /* renamed from: D */
    private static int[] m66647D(ArrayList<MediaItem> arrayList) {
        AppMethodBeat.m2504i(21424);
        int[] iArr = new int[4];
        iArr[0] = arrayList.size();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            MediaItem mediaItem = (MediaItem) it.next();
            if (mediaItem != null) {
                if (!C5046bo.isNullOrNil(mediaItem.mMimeType) && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                    iArr[2] = iArr[2] + 1;
                } else if (mediaItem.getType() == 2) {
                    iArr[3] = iArr[3] + 1;
                } else if (mediaItem.getType() == 1) {
                    iArr[1] = iArr[1] + 1;
                }
            }
        }
        AppMethodBeat.m2505o(21424);
        return iArr;
    }

    /* renamed from: a */
    private void m66663a(AlbumItem albumItem) {
        AppMethodBeat.m2504i(21425);
        if (albumItem == null) {
            AppMethodBeat.m2505o(21425);
        } else if (C5046bo.m7532bc(this.mPr, "").equals(albumItem.mOh)) {
            C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "want to reset folder, same folder, return");
            AppMethodBeat.m2505o(21425);
        } else {
            C34237e.bCe().addAll(this.mPj.mOI);
            C4990ab.m7411d("MicroMsg.AlbumPreviewUI", "reset folder[%s], path[%s]", albumItem.mOh, albumItem.mo7500Wy());
            this.mPq = albumItem.mo7500Wy();
            this.mPr = albumItem.mOh;
            if (albumItem.oqq != null) {
                this.mPs = albumItem.oqq.getType();
            }
            if (C5046bo.isNullOrNil(this.mPq)) {
                C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "reset folder path failed");
                this.mPq = this.mPr;
            }
            if (C5046bo.isNullOrNil(this.mPr)) {
                if (getIntent().getBooleanExtra("show_header_view", true)) {
                    this.mPj.mo23926a(this.mPL);
                }
                updateTitle();
                this.mPs = C34237e.bBZ().mOu;
            } else {
                C12092a c12092a = this.mPj;
                C12095a c12095a = this.mPL;
                if (c12095a == null) {
                    C4990ab.m7420w("MicroMsg.AlbumAdapter", "removeHeader error, header is null");
                } else {
                    c12092a.mOM.remove(c12095a);
                }
                this.mPi.setText(this.mPr);
            }
            this.mPj.mOH.clear();
            m66693wu(this.mPj.mOI.size());
            this.mPj.notifyDataSetChanged();
            if (this.ehJ != null) {
                this.ehJ.dismiss();
            }
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, new C3916812());
            start = System.currentTimeMillis();
            String str = this.mPr;
            if (albumItem.oqq == null) {
                AppMethodBeat.m2505o(21425);
                return;
            }
            int type = albumItem.oqq.getType();
            C4990ab.m7417i("MicroMsg.AlbumPreviewUI", "folder type[%d] queryType[%d]", Integer.valueOf(type), Integer.valueOf(C34237e.bBZ().mOu));
            if (C34237e.bBZ().mOu != 2 && albumItem.oqq.getType() == 2) {
                str = "";
            }
            if (C5046bo.isNullOrNil(albumItem.mOh)) {
                type = 3;
            }
            this.mPK = System.currentTimeMillis();
            C34237e.bBZ().mo73864g(str, type, this.mPK);
            AppMethodBeat.m2505o(21425);
        }
    }

    /* renamed from: V */
    public final void mo62068V(int i, boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(21426);
        switch (C34237e.bBZ().mOu) {
            case 3:
                if (!(C5046bo.isNullOrNil(this.cEV) || "medianote".equals(this.toUser))) {
                    if (C5046bo.m7588yz() - this.mPF >= 1000) {
                        C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                        MediaItem mediaItem = (MediaItem) this.mPj.mOH.get(i);
                        if (mediaItem.getType() != 2) {
                            try {
                                C34241a c34241a = this.mOG;
                                String str = mediaItem.fPT;
                                String str2 = this.toUser;
                                if (!this.mPu) {
                                    if (this.kvs) {
                                        z2 = false;
                                    }
                                }
                                c34241a.mo36246a(str, str2, z2, 0, z);
                                AppMethodBeat.m2505o(21426);
                                return;
                            } catch (Exception e) {
                                break;
                            }
                        }
                    }
                    C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
                    AppMethodBeat.m2505o(21426);
                    return;
                }
                break;
        }
        AppMethodBeat.m2505o(21426);
    }

    public final void initView() {
        boolean z;
        AppMethodBeat.m2504i(21427);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            for (String str : extras.keySet()) {
                C4990ab.m7411d("MicroMsg.AlbumPreviewUI", "key=%s | value=%s", str, extras.get(str));
            }
        } else {
            C4990ab.m7412e("MicroMsg.AlbumPreviewUI", "initView, oops! no extras data!");
        }
        this.mOL = getIntent().getStringExtra("album_business_tag");
        this.gLP = getIntent().getIntExtra("album_video_max_duration", 10);
        this.cEV = getIntent().getStringExtra("GalleryUI_FromUser");
        this.toUser = getIntent().getStringExtra("GalleryUI_ToUser");
        this.mPA = getIntent().getIntExtra("max_select_count", 9);
        this.mPu = C34237e.bBZ().hOZ == 4;
        if (C34237e.bBZ().hOZ == 5) {
            z = true;
        } else {
            z = false;
        }
        this.mPw = z;
        if (C34237e.bBZ().hOZ == 9) {
            z = true;
        } else {
            z = false;
        }
        this.mPx = z;
        this.mPq = getIntent().getStringExtra("folder_path");
        this.mPr = getIntent().getStringExtra("folder_name");
        if (C5046bo.isNullOrNil(this.mPq)) {
            C4990ab.m7412e("MicroMsg.AlbumPreviewUI", "get folder path failed");
            this.mPq = this.mPr;
        }
        this.kvs = getIntent().getBooleanExtra("key_send_raw_image", false);
        this.mPy = getIntent().getBooleanExtra("key_can_select_video_and_pic", false);
        this.mPo = (TextView) findViewById(2131822756);
        this.mPp = (ImageButton) findViewById(2131822755);
        this.mPo.setOnClickListener(new C3916213());
        if (C34237e.bBZ().hOZ == 3) {
            this.mPp.setVisibility(0);
            this.mPo.setVisibility(0);
        } else {
            this.mPp.setVisibility(8);
            this.mPo.setVisibility(8);
        }
        if (this.kvs) {
            this.mPp.setImageResource(C1318a.radio_on);
        } else {
            this.mPp.setImageResource(C1318a.radio_off);
        }
        this.mPp.setOnClickListener(new C3916914());
        this.mPk = (TextView) findViewById(2131823946);
        this.mPl = (TextView) findViewById(2131827230);
        this.mPm = (TextView) findViewById(2131827231);
        this.mPf = (TextView) findViewById(2131827236);
        if (C34237e.bBZ().hOZ == 0 || C34237e.bBZ().hOZ == 5 || C34237e.bBZ().hOZ == 10 || C34237e.bBZ().hOZ == 11 || C34237e.bBZ().hOZ == 14) {
            findViewById(2131827235).setVisibility(8);
            this.mPf.setVisibility(8);
        } else {
            this.mPf.setVisibility(0);
            this.mPf.setOnClickListener(new C1208115());
            if ((C34237e.bBZ().mOu == 1 || C34237e.bBZ().mOu == 2 || C34237e.bBZ().mOu == 3) && this.mPA > 0) {
                C2816116 c2816116 = new C2816116();
                if (!C5046bo.isNullOrNil(this.mPt)) {
                    addTextOptionMenu(0, this.mPt, c2816116);
                } else if (C34237e.bBZ().hOZ != 14) {
                    mo17379a(0, m66694wv(0), (OnMenuItemClickListener) c2816116, C5535b.GREEN);
                }
            }
        }
        this.mPn = (ImageFolderMgrView) findViewById(2131827237);
        ImageFolderMgrView imageFolderMgrView = this.mPn;
        C34237e.bBZ().mo73862b(imageFolderMgrView);
        C34237e.bBZ().mo73861a(imageFolderMgrView);
        C34237e.bBZ().bCu();
        this.mPn.setListener(new C320917());
        this.mPt = getIntent().getStringExtra("send_btn_string");
        findViewById(2131827233).setOnClickListener(new C1208218());
        this.mPi = (TextView) findViewById(2131827234);
        if (this.mPw) {
            showOptionMenu(false);
        }
        enableOptionMenu(false);
        this.mPe = (GridView) findViewById(2131827229);
        this.mPe.setOnItemClickListener(new C281622());
        this.mPj = new C12092a(this, new C120843());
        if (!C5046bo.isNullOrNil(this.mOL)) {
            C4990ab.m7411d("MicroMsg.AlbumPreviewUI", "businessTag=%s", this.mOL);
            this.mPj.mOL = this.mOL;
            this.mPj.gLP = this.gLP;
            if (this.mOL.equals("album_business_bubble_media_by_coordinate")) {
                C34237e.bBZ().mOt.bBV();
                this.mPI = getIntent().getStringExtra("album_business_bubble_media_by_coordinate_posname");
                final double doubleExtra = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_distance", -1.0d);
                this.longitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_longitude", 91.0d);
                this.latitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_latitude", 181.0d);
                if (doubleExtra > 0.0d && C42205a.m74463q(this.longitude) && C42205a.m74464r(this.latitude)) {
                    this.mPJ = new C43144b() {
                        /* renamed from: b */
                        public final void mo62070b(LinkedList<MediaItem> linkedList, long j) {
                            AppMethodBeat.m2504i(21391);
                            C4990ab.m7410d("MicroMsg.AlbumPreviewUI", "onQueryMediaBusinessDoing");
                            if (j != AlbumPreviewUI.this.mPK) {
                                C4990ab.m7421w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", Long.valueOf(j), Long.valueOf(AlbumPreviewUI.this.mPK));
                                C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
                                AppMethodBeat.m2505o(21391);
                            } else if (linkedList == null || !linkedList.isEmpty()) {
                                ArrayList arrayList = new ArrayList();
                                Iterator it = linkedList.iterator();
                                while (it.hasNext()) {
                                    MediaItem mediaItem = (MediaItem) it.next();
                                    if (TencentLocationUtils.distanceBetween(AlbumPreviewUI.this.latitude, AlbumPreviewUI.this.longitude, mediaItem.bDG, mediaItem.bDH) <= doubleExtra) {
                                        mediaItem.mOn = "album_business_bubble_media_by_coordinate";
                                        arrayList.add(mediaItem);
                                    }
                                }
                                linkedList.removeAll(arrayList);
                                C4990ab.m7411d("MicroMsg.AlbumPreviewUI", "target media size=%d", Integer.valueOf(arrayList.size()));
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    C4990ab.m7411d("MicroMsg.AlbumPreviewUI", "target media item=%s", ((MediaItem) it2.next()).toString());
                                }
                                if (!(linkedList.isEmpty() || arrayList.isEmpty())) {
                                    linkedList.addAll(0, arrayList);
                                }
                                AppMethodBeat.m2505o(21391);
                            } else {
                                C4990ab.m7410d("MicroMsg.AlbumPreviewUI", "mediaItems is empty.");
                                AppMethodBeat.m2505o(21391);
                            }
                        }
                    };
                    C45980l bBZ = C34237e.bBZ();
                    C43144b c43144b = this.mPJ;
                    if (c43144b != null) {
                        bBZ.mOs.add(c43144b);
                    }
                    this.mPj.mON = false;
                }
            }
        }
        if (this.mPu) {
            this.mPj.mON = true;
        }
        if (this.mPy) {
            this.mPj.mON = true;
        }
        this.mPe.setNumColumns(4);
        this.mPe.setOnScrollListener(new C391705());
        if (getIntent().getBooleanExtra("show_header_view", true)) {
            this.mPj.mo23926a(this.mPL);
        }
        this.mPj.mOK = C34237e.bBZ().mOu;
        this.mPj.mOF = this.mPA;
        C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "limit count = " + getIntent().getIntExtra("max_select_count", 9));
        this.mPe.setAdapter(this.mPj);
        updateTitle();
        setBackBtn(new C391636());
        ViewGroup viewGroup = (ViewGroup) findViewById(2131820987);
        if (viewGroup instanceof DrawedCallBackFrameLayout) {
            ((DrawedCallBackFrameLayout) viewGroup).setListener(new C391717());
        }
        AppMethodBeat.m2505o(21427);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(21429);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "onKeyDown");
            setResult(-2);
            if (this.mPn.aej) {
                this.mPn.bCE();
                AppMethodBeat.m2505o(21429);
                return true;
            }
            finish();
            AppMethodBeat.m2505o(21429);
            return true;
        } else if (i == 82) {
            this.mPE++;
            this.mPn.bCE();
            AppMethodBeat.m2505o(21429);
            return true;
        } else {
            boolean onKeyDown = super.onKeyDown(i, keyEvent);
            AppMethodBeat.m2505o(21429);
            return onKeyDown;
        }
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(21430);
        C4990ab.m7417i("MicroMsg.AlbumPreviewUI", "on activity result, requestCode[%d] resultCode[%d]", Integer.valueOf(i), Integer.valueOf(i2));
        ArrayList arrayList;
        if (4369 != i) {
            ArrayList stringArrayListExtra;
            if (4370 != i) {
                if (4371 != i) {
                    if (4372 != i) {
                        if (4373 != i) {
                            if (4375 != i) {
                                if (4376 != i) {
                                    switch (i2) {
                                        case -2:
                                            C4990ab.m7412e("MicroMsg.AlbumPreviewUI", "WTF!!!");
                                            finish();
                                            break;
                                        case -1:
                                            if (intent == null) {
                                                intent = new Intent();
                                                intent.putExtra("CropImage_Compress_Img", true);
                                                intent.putStringArrayListExtra("CropImage_OutputPath_List", this.mPj.bCw());
                                            }
                                            C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "onActivity Result ok");
                                            this.mPh = true;
                                            setResult(-1, intent);
                                            bCA();
                                            finish();
                                            break;
                                        case 0:
                                            if (intent != null) {
                                                boolean z;
                                                stringArrayListExtra = intent.getStringArrayListExtra("preview_image_list");
                                                if (stringArrayListExtra != null) {
                                                    this.mPj.mo23925C(stringArrayListExtra);
                                                    this.mPj.notifyDataSetChanged();
                                                    m66693wu(stringArrayListExtra.size());
                                                }
                                                if (intent.getBooleanExtra("CropImage_Compress_Img", true)) {
                                                    z = false;
                                                } else {
                                                    z = true;
                                                }
                                                this.kvs = z;
                                                if (!this.kvs) {
                                                    this.mPp.setImageResource(C1318a.radio_off);
                                                    break;
                                                } else {
                                                    this.mPp.setImageResource(C1318a.radio_on);
                                                    break;
                                                }
                                            }
                                            break;
                                    }
                                } else if (-1 != i2) {
                                    C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "REQUEST_SELECT_FOLDER goBack!");
                                    finish();
                                } else if (intent != null) {
                                    AlbumItem albumItem = (AlbumItem) intent.getParcelableExtra("select_folder_name");
                                    m66663a(albumItem);
                                    setMMTitle(C5046bo.m7532bc(albumItem.mOh, getString(C25738R.string.c34)));
                                }
                            } else if (-1 != i2) {
                                AppMethodBeat.m2505o(21430);
                                return;
                            } else {
                                if (intent == null) {
                                    intent = new Intent();
                                }
                                C4990ab.m7417i("MicroMsg.AlbumPreviewUI", "sight capture record video, result[%s]", intent);
                                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                                if (sightCaptureResult == null) {
                                    C4990ab.m7412e("MicroMsg.AlbumPreviewUI", "sight capture result is null!");
                                    setResult(1);
                                    finish();
                                    AppMethodBeat.m2505o(21430);
                                    return;
                                }
                                arrayList = new ArrayList();
                                String str = sightCaptureResult.osC;
                                if (!C5046bo.isNullOrNil(str)) {
                                    arrayList.add(str);
                                    intent.putExtra("key_select_video_list", arrayList);
                                }
                                if (sightCaptureResult.osA && !C5046bo.isNullOrNil(sightCaptureResult.osI)) {
                                    arrayList = new ArrayList();
                                    arrayList.add(sightCaptureResult.osI);
                                    intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList);
                                }
                                setResult(-1, intent);
                                finish();
                            }
                        } else {
                            if (intent != null) {
                                intent.putExtra("GalleryUI_IsSendImgBackground", true);
                                C4990ab.m7412e("MicroMsg.AlbumPreviewUI", "send img background, data is null!!");
                            }
                            C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "Request code sendimg proxy");
                            setResult(-1, intent);
                            this.mPC = true;
                            finish();
                        }
                    } else if (-1 != i2) {
                        AppMethodBeat.m2505o(21430);
                        return;
                    } else {
                        if (intent == null) {
                            intent = new Intent();
                        }
                        C4990ab.m7417i("MicroMsg.AlbumPreviewUI", "system record video, result[%s]", intent);
                        stringArrayListExtra = new ArrayList();
                        String stringExtra = getIntent().getStringExtra("video_full_path");
                        if (!C5046bo.isNullOrNil(stringExtra)) {
                            stringArrayListExtra.add(stringExtra);
                            intent.putExtra("key_select_video_list", stringArrayListExtra);
                            intent.putExtra("key_selected_video_is_from_sys_camera", true);
                        }
                        setResult(-1, intent);
                        finish();
                    }
                } else if (-1 != i2) {
                    AppMethodBeat.m2505o(21430);
                    return;
                } else {
                    if (intent != null) {
                        intent.putExtra("from_record", true);
                    }
                    C4990ab.m7417i("MicroMsg.AlbumPreviewUI", "custom record video, result[%s]", intent);
                    setResult(-1, intent);
                    finish();
                }
            } else if (-1 != i2) {
                AppMethodBeat.m2505o(21430);
                return;
            } else if (intent.getBooleanExtra("GalleryUI_IsSendImgBackground", false)) {
                C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "test onActivityResult");
                setResult(-1, intent);
                finish();
                AppMethodBeat.m2505o(21430);
                return;
            } else {
                stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
                    C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "send filepath is null or nil");
                    AppMethodBeat.m2505o(21430);
                    return;
                }
                C4990ab.m7417i("MicroMsg.AlbumPreviewUI", "gallery photo:%s", stringArrayListExtra);
                setResult(-1, intent);
                finish();
            }
        } else if (-1 != i2) {
            AppMethodBeat.m2505o(21430);
            return;
        } else {
            String h = C14987n.m23320h(this.mController.ylL.getApplicationContext(), intent, C6457e.euR);
            if (C5046bo.isNullOrNil(h)) {
                C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "take photo, but result is null");
                AppMethodBeat.m2505o(21430);
                return;
            }
            C4990ab.m7417i("MicroMsg.AlbumPreviewUI", "take photo, result[%s]", h);
            if (C34237e.bBZ().hOZ == 0 || C34237e.bBZ().hOZ == 5 || C34237e.bBZ().hOZ == 11) {
                Intent intent2 = new Intent();
                intent2.setData(Uri.parse("file://" + Uri.encode(h)));
                C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "take photo finish");
                setResult(-1, intent2);
                finish();
            } else {
                arrayList = new ArrayList(1);
                arrayList.add(h);
                Intent intent3 = new Intent(this, ImagePreviewUI.class);
                intent3.putExtra("isTakePhoto", true);
                intent3.putExtra("max_select_count", 1);
                intent3.putExtra("send_raw_img", this.kvs);
                intent3.putStringArrayListExtra("preview_image_list", arrayList);
                intent3.putExtra("GalleryUI_FromUser", this.cEV);
                intent3.putExtra("GalleryUI_ToUser", this.toUser);
                startActivityForResult(intent3, 4370);
            }
        }
        if (intent != null && intent.getBooleanExtra("show_photo_edit_tip", false)) {
            SharedPreferences sharedPreferences = getSharedPreferences("photo_edit_pref", 0);
            if (!sharedPreferences.getBoolean("has_show_tip", false)) {
                this.mPm.setVisibility(0);
                this.mPm.setText(getString(C25738R.string.dci));
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mController.ylL, C25738R.anim.f8332b5);
                this.mPm.startAnimation(loadAnimation);
                loadAnimation.setAnimationListener(new C281679());
                sharedPreferences.edit().putBoolean("has_show_tip", true).commit();
            }
        }
        AppMethodBeat.m2505o(21430);
    }

    /* renamed from: wu */
    private void m66693wu(int i) {
        AppMethodBeat.m2504i(21431);
        if (i == 0) {
            this.mPf.setEnabled(false);
            enableOptionMenu(false);
        } else {
            this.mPf.setEnabled(true);
            enableOptionMenu(true);
        }
        if (i == 0) {
            this.mPf.setText(C25738R.string.c3j);
        } else {
            this.mPf.setText(getString(C25738R.string.c3j) + "(" + i + ")");
        }
        updateOptionMenuText(0, m66694wv(i));
        AppMethodBeat.m2505o(21431);
    }

    /* renamed from: wv */
    private String m66694wv(int i) {
        AppMethodBeat.m2504i(21432);
        String string;
        switch (C34237e.bBZ().hOZ) {
            case 4:
            case 8:
            case 13:
                if (i == 0 || this.mPA <= 1) {
                    string = getString(C25738R.string.c3k);
                    AppMethodBeat.m2505o(21432);
                    return string;
                }
                string = getString(C25738R.string.c3k) + "(" + i + "/" + this.mPA + ")";
                AppMethodBeat.m2505o(21432);
                return string;
            case 7:
                if (C5046bo.isNullOrNil(this.mOL) || !this.mOL.equals("album_business_bubble_media_by_coordinate")) {
                    if (i == 0 || this.mPA <= 1) {
                        string = getString(C25738R.string.c3k);
                        AppMethodBeat.m2505o(21432);
                        return string;
                    }
                    string = getString(C25738R.string.c3k) + "(" + i + "/" + this.mPA + ")";
                    AppMethodBeat.m2505o(21432);
                    return string;
                } else if (i == 0 || this.mPA <= 1) {
                    string = getString(C25738R.string.f9182s1);
                    AppMethodBeat.m2505o(21432);
                    return string;
                } else {
                    string = getString(C25738R.string.f9182s1) + "(" + i + "/" + this.mPA + ")";
                    AppMethodBeat.m2505o(21432);
                    return string;
                }
            default:
                if (i == 0 || this.mPA <= 1) {
                    string = getString(C25738R.string.f9221tf);
                    AppMethodBeat.m2505o(21432);
                    return string;
                }
                string = getString(C25738R.string.c3c, new Object[]{Integer.valueOf(i), Integer.valueOf(this.mPA)});
                AppMethodBeat.m2505o(21432);
                return string;
        }
    }

    /* renamed from: c */
    public final void mo62069c(LinkedList<MediaItem> linkedList, long j) {
        boolean z = true;
        AppMethodBeat.m2504i(21433);
        if (j != this.mPK) {
            C4990ab.m7421w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", Long.valueOf(j), Long.valueOf(this.mPK));
            C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
            AppMethodBeat.m2505o(21433);
            return;
        }
        LinkedList linkedList2 = new LinkedList();
        if (linkedList != null) {
            linkedList2.addAll(linkedList);
        }
        String str = "MicroMsg.AlbumPreviewUI";
        String str2 = "[onQueryMediaFinished] adapter is null?:%s";
        Object[] objArr = new Object[1];
        if (this.mPj != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        if (this.mPj != null) {
            C39166a c39166a = new C39166a();
            c39166a.mPW = new WeakReference(this.mPj);
            c39166a.mPX = new WeakReference(this.ehJ);
            c39166a.mPY = new WeakReference(this.mPl);
            c39166a.mPZ = new WeakReference(this.mPe);
            c39166a.mQa = linkedList2;
            c39166a.mQb = new WeakReference(this.mPI);
            C34237e.bCa().mo36236d(c39166a);
        }
        AppMethodBeat.m2505o(21433);
    }

    private void bCA() {
        AppMethodBeat.m2504i(21434);
        if (this.mPM) {
            SharedPreferences sharedPreferences = getSharedPreferences("gallery_last_choose_album", 0);
            C4990ab.m7416i("MicroMsg.AlbumPreviewUI", "last selected folderName and path: " + this.mPr + ", " + this.mPq);
            sharedPreferences.edit().putString(C34237e.bBZ().mOu, this.mPr + "|" + this.mPq + "|" + this.mPs).commit();
            AppMethodBeat.m2505o(21434);
            return;
        }
        AppMethodBeat.m2505o(21434);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(21435);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.AlbumPreviewUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(21435);
            return;
        }
        C4990ab.m7417i("MicroMsg.AlbumPreviewUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dbs), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C3916010(), null);
                    break;
                }
                bCz();
                AppMethodBeat.m2505o(21435);
                return;
        }
        AppMethodBeat.m2505o(21435);
    }

    /* renamed from: a */
    private boolean m66666a(MediaItem mediaItem) {
        AppMethodBeat.m2504i(21436);
        if (mediaItem == null) {
            C4990ab.m7412e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] item is null!");
            AppMethodBeat.m2505o(21436);
            return false;
        } else if (this.mOG == null) {
            C4990ab.m7412e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] invoker is null!");
            AppMethodBeat.m2505o(21436);
            return false;
        } else if (C34237e.bBZ().hOZ != 3) {
            AppMethodBeat.m2505o(21436);
            return true;
        } else if (new File(mediaItem.fPT).exists()) {
            try {
                if (this.mOG.mo36242ND(mediaItem.fPT) > 300) {
                    C30379h.m48464bP(this, getString(C25738R.string.c43));
                    AppMethodBeat.m2505o(21436);
                    return false;
                }
            } catch (RemoteException e) {
                C4990ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
            }
            AppMethodBeat.m2505o(21436);
            return true;
        } else {
            C30379h.m48464bP(this, getString(C25738R.string.c41));
            AppMethodBeat.m2505o(21436);
            return false;
        }
    }

    private void bCz() {
        AppMethodBeat.m2504i(21428);
        if (C14987n.m23311c(this.mController.ylL, C6457e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG, 4369)) {
            C34237e.bCa().mo36237wp(0);
            System.gc();
            AppMethodBeat.m2505o(21428);
            return;
        }
        Toast.makeText(this.mController.ylL, getString(C25738R.string.e29), 1).show();
        AppMethodBeat.m2505o(21428);
    }

    /* renamed from: e */
    static /* synthetic */ void m66674e(AlbumPreviewUI albumPreviewUI) {
        AppMethodBeat.m2504i(21437);
        if (albumPreviewUI.kvs) {
            Iterator it = albumPreviewUI.mPj.mOI.iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                MediaItem mediaItem = (MediaItem) it.next();
                if (mediaItem != null && mediaItem.getType() == 1) {
                    if (26214400 < C1173e.m2560cs(mediaItem.fPT)) {
                        C4990ab.m7421w("MicroMsg.AlbumPreviewUI", "[onClick] item:%s file size:%s", mediaItem, Integer.valueOf(C1173e.m2560cs(mediaItem.fPT)));
                        i2++;
                    }
                    i++;
                }
                i = i;
            }
            if (i2 > 0) {
                if (i == i2) {
                    C30379h.m48464bP(albumPreviewUI, albumPreviewUI.getString(C25738R.string.c40));
                    AppMethodBeat.m2505o(21437);
                    return;
                }
                C30379h.m48464bP(albumPreviewUI, albumPreviewUI.getString(C25738R.string.c3x));
            }
        }
        AppMethodBeat.m2505o(21437);
    }

    /* renamed from: g */
    static /* synthetic */ void m66676g(AlbumPreviewUI albumPreviewUI) {
        AppMethodBeat.m2504i(21438);
        if (albumPreviewUI.mPj.mOI.size() > 0) {
            albumPreviewUI.enableOptionMenu(true);
            AppMethodBeat.m2505o(21438);
            return;
        }
        albumPreviewUI.enableOptionMenu(false);
        AppMethodBeat.m2505o(21438);
    }

    /* renamed from: s */
    static /* synthetic */ void m66688s(AlbumPreviewUI albumPreviewUI) {
        AppMethodBeat.m2504i(21439);
        C30379h.m48467g(albumPreviewUI, C25738R.string.f15, C25738R.string.c4_);
        C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "video is import error");
        AppMethodBeat.m2505o(21439);
    }

    /* renamed from: t */
    static /* synthetic */ void m66689t(AlbumPreviewUI albumPreviewUI) {
        AppMethodBeat.m2504i(21440);
        C30379h.m48467g(albumPreviewUI, C25738R.string.c49, C25738R.string.c4_);
        C4990ab.m7420w("MicroMsg.AlbumPreviewUI", "video is over size");
        AppMethodBeat.m2505o(21440);
    }

    /* renamed from: W */
    static /* synthetic */ void m66658W(LinkedList linkedList) {
        AppMethodBeat.m2504i(21446);
        if (linkedList == null) {
            C4990ab.m7412e("MicroMsg.AlbumPreviewUI", "[filterEditMediaItem] mMediaItems is null!");
            AppMethodBeat.m2505o(21446);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        C4990ab.m7417i("MicroMsg.AlbumPreviewUI", "[filterEditMediaItem] size:%s", Integer.valueOf(linkedList.size()));
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedList.iterator();
        int i = 0;
        while (it.hasNext()) {
            MediaItem mediaItem = (MediaItem) it.next();
            Iterator it2 = C34237e.bCc().iterator();
            while (it2.hasNext()) {
                MediaItem mediaItem2 = (MediaItem) it2.next();
                if (mediaItem2.mOi.equals(mediaItem.fPT)) {
                    C4990ab.m7411d("MicroMsg.AlbumPreviewUI", "item:%s replace editItem:%s", mediaItem, mediaItem2);
                    linkedList.set(i, mediaItem2);
                }
                if (mediaItem2.fPT.equals(mediaItem.fPT)) {
                    C4990ab.m7411d("MicroMsg.AlbumPreviewUI", "remove editItem:%s", mediaItem2);
                    arrayList.add(Integer.valueOf(i));
                }
            }
            i++;
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            linkedList.remove(((Integer) it3.next()).intValue());
        }
        C4990ab.m7411d("MicroMsg.AlbumPreviewUI", "[filterEditMediaItem] cost%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(21446);
    }
}
