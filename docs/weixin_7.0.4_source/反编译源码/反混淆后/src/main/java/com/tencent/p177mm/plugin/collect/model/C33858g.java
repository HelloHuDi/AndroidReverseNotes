package com.tencent.p177mm.plugin.collect.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p230g.p231a.C37696bx;
import com.tencent.p177mm.p230g.p232b.p233a.C18439bf;
import com.tencent.p177mm.plugin.collect.model.voice.C45818a.C20267c;
import com.tencent.p177mm.plugin.collect.p1481a.C45815a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.tencent.mm.plugin.collect.model.g */
public final class C33858g extends C4884c<C37696bx> implements C1202f, C20267c {
    private static final String kBK = (C6457e.eSn + "wallet/voice/");
    private static final C1332b kBL = C1332b.akB("元");
    private boolean isPlaying;
    private MediaPlayer kBM;
    private MediaPlayer kBN;
    public ConcurrentLinkedQueue<C33857b> kBO;
    private int kBP;
    private int kBQ;
    private long kBR;
    private WeakReference<ArrayList<String>> kBS;
    private C18439bf kBT;

    /* renamed from: com.tencent.mm.plugin.collect.model.g$3 */
    class C114163 implements Runnable {
        C114163() {
        }

        public final void run() {
            AppMethodBeat.m2504i(40936);
            if (C33858g.this.kBM != null && C33858g.this.isPlaying && C33858g.this.kBN == null) {
                C4990ab.m7416i("MicroMsg.F2fRcvVoiceListener", "this play may error");
                C7060h.pYm.mo8378a(699, 1, 1, false);
            }
            AppMethodBeat.m2505o(40936);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.model.g$a */
    static class C11417a {
        /* JADX WARNING: Removed duplicated region for block: B:34:0x011d A:{SYNTHETIC, Splitter:B:34:0x011d} */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x011d A:{SYNTHETIC, Splitter:B:34:0x011d} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public static MediaPlayer m19174a(Context context, final OnCompletionListener onCompletionListener, final OnErrorListener onErrorListener) {
            Exception e;
            Throwable th;
            AppMethodBeat.m2504i(40945);
            if (context == null) {
                C4990ab.m7413e("MicroMsg.F2fRcvVoiceListener", "play Err context:%s pathId:%d", context, Integer.valueOf(C25738R.string.asp));
                AppMethodBeat.m2505o(40945);
                return null;
            }
            final String string = context.getString(C25738R.string.asp);
            final MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(3);
            C4990ab.m7417i("MicroMsg.F2fRcvVoiceListener", "play start mp:%d path:%s context:%s pathId:%d", Integer.valueOf(mediaPlayer.hashCode()), string, context, Integer.valueOf(C25738R.string.asp));
            AssetFileDescriptor assetFileDescriptor = null;
            AssetFileDescriptor openFd;
            try {
                openFd = context.getAssets().openFd(string);
                try {
                    boolean z;
                    mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                    mediaPlayer.setLooping(false);
                    mediaPlayer.setOnErrorListener(new OnErrorListener() {
                        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            AppMethodBeat.m2504i(40941);
                            C4990ab.m7417i("MicroMsg.F2fRcvVoiceListener", "onError, what: %d, extra: %d", Integer.valueOf(i), Integer.valueOf(i2));
                            if (mediaPlayer != null) {
                                try {
                                    mediaPlayer.release();
                                } catch (Exception e) {
                                }
                            }
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                            }
                            if (onErrorListener != null) {
                                onErrorListener.onError(mediaPlayer, i, i2);
                            }
                            AppMethodBeat.m2505o(40941);
                            return false;
                        }
                    });
                    mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            AppMethodBeat.m2504i(40942);
                            String str = "MicroMsg.F2fRcvVoiceListener";
                            String str2 = "play completion mp:%d  path:%s";
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(mediaPlayer == null ? -1 : mediaPlayer.hashCode());
                            objArr[1] = string;
                            C4990ab.m7417i(str, str2, objArr);
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                            }
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                            }
                            if (onCompletionListener != null) {
                                onCompletionListener.onCompletion(mediaPlayer);
                            }
                            AppMethodBeat.m2505o(40942);
                        }
                    });
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    String str = "MicroMsg.F2fRcvVoiceListener";
                    String str2 = "play start mp finish [%d], myLooper[%b] mainLooper[%b]";
                    Object[] objArr = new Object[3];
                    objArr[0] = Integer.valueOf(mediaPlayer.hashCode());
                    if (Looper.myLooper() != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[1] = Boolean.valueOf(z);
                    if (Looper.getMainLooper() != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[2] = Boolean.valueOf(z);
                    C4990ab.m7417i(str, str2, objArr);
                    if (openFd != null) {
                        try {
                            openFd.close();
                        } catch (IOException e2) {
                            C4990ab.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e2, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.m2505o(40945);
                    return mediaPlayer;
                } catch (Exception e3) {
                    e = e3;
                    assetFileDescriptor = openFd;
                    try {
                        C4990ab.m7413e("MicroMsg.F2fRcvVoiceListener", "play failed pathId:%d e:%s", Integer.valueOf(C25738R.string.asp), e.getMessage());
                        C4990ab.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e, "", new Object[0]);
                        mediaPlayer.release();
                        if (assetFileDescriptor != null) {
                            try {
                                assetFileDescriptor.close();
                            } catch (IOException e4) {
                                C4990ab.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e4, "", new Object[0]);
                            }
                        }
                        AppMethodBeat.m2505o(40945);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        openFd = assetFileDescriptor;
                        if (openFd != null) {
                        }
                        AppMethodBeat.m2505o(40945);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (openFd != null) {
                    }
                    AppMethodBeat.m2505o(40945);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            } catch (Throwable th4) {
                th = th4;
                openFd = null;
                if (openFd != null) {
                    try {
                        openFd.close();
                    } catch (IOException e22) {
                        C4990ab.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e22, "", new Object[0]);
                    }
                }
                AppMethodBeat.m2505o(40945);
                throw th;
            }
        }

        /* renamed from: a */
        public static MediaPlayer m19175a(final String str, final OnCompletionListener onCompletionListener, final OnErrorListener onErrorListener) {
            AppMethodBeat.m2504i(40946);
            final MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(3);
            C4990ab.m7417i("MicroMsg.F2fRcvVoiceListener", "play start mp:%d path:%s", Integer.valueOf(mediaPlayer.hashCode()), str);
            try {
                mediaPlayer.setDataSource(str);
                mediaPlayer.setLooping(false);
                mediaPlayer.setOnErrorListener(new OnErrorListener() {
                    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        AppMethodBeat.m2504i(40943);
                        C4990ab.m7417i("MicroMsg.F2fRcvVoiceListener", "onError, what: %d, extra: %d", Integer.valueOf(i), Integer.valueOf(i2));
                        if (mediaPlayer != null) {
                            try {
                                mediaPlayer.release();
                            } catch (Exception e) {
                            }
                        }
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        if (onErrorListener != null) {
                            onErrorListener.onError(mediaPlayer, i, i2);
                        }
                        AppMethodBeat.m2505o(40943);
                        return false;
                    }
                });
                mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        AppMethodBeat.m2504i(40944);
                        String str = "MicroMsg.F2fRcvVoiceListener";
                        String str2 = "play completion mp:%d  path:%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(mediaPlayer == null ? -1 : mediaPlayer.hashCode());
                        objArr[1] = str;
                        C4990ab.m7417i(str, str2, objArr);
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        if (onCompletionListener != null) {
                            onCompletionListener.onCompletion(mediaPlayer);
                        }
                        AppMethodBeat.m2505o(40944);
                    }
                });
                mediaPlayer.prepare();
                mediaPlayer.start();
                String str2 = "MicroMsg.F2fRcvVoiceListener";
                String str3 = "play start mp finish [%d], myLooper[%b] mainLooper[%b]";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(mediaPlayer.hashCode());
                objArr[1] = Boolean.valueOf(Looper.myLooper() != null);
                objArr[2] = Boolean.valueOf(Looper.getMainLooper() != null);
                C4990ab.m7417i(str2, str3, objArr);
                AppMethodBeat.m2505o(40946);
                return mediaPlayer;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.F2fRcvVoiceListener", "play failed path:%s e:%s", str, e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", e, "", new Object[0]);
                mediaPlayer.release();
                AppMethodBeat.m2505o(40946);
                return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.model.g$b */
    class C33857b {
        int cAO;
        String cva;
        String fileName;
        int kBZ;
        int kCa;
        boolean kCb;

        private C33857b() {
            this.kCa = 0;
            this.kCb = false;
        }

        /* synthetic */ C33857b(C33858g c33858g, byte b) {
            this();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m55406a(C33858g c33858g, C33857b c33857b) {
        AppMethodBeat.m2504i(40962);
        c33858g.m55405a(c33857b);
        AppMethodBeat.m2505o(40962);
    }

    static /* synthetic */ boolean bgE() {
        AppMethodBeat.m2504i(40965);
        boolean bgB = C33858g.bgB();
        AppMethodBeat.m2505o(40965);
        return bgB;
    }

    /* renamed from: h */
    static /* synthetic */ void m55414h(C33858g c33858g) {
        AppMethodBeat.m2504i(40964);
        c33858g.bgC();
        AppMethodBeat.m2505o(40964);
    }

    static {
        AppMethodBeat.m2504i(40966);
        AppMethodBeat.m2505o(40966);
    }

    public C33858g() {
        AppMethodBeat.m2504i(40947);
        this.isPlaying = false;
        this.xxI = C37696bx.class.getName().hashCode();
        AppMethodBeat.m2505o(40947);
    }

    private List<String> bgA() {
        AppMethodBeat.m2504i(40948);
        if (this.kBS == null || this.kBS.get() == null) {
            C4990ab.m7416i("MicroMsg.F2fRcvVoiceListener", "refer is null");
            this.kBS = new WeakReference(new ArrayList(C5046bo.m7569hT((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_F2F_RCV_VOICE_PLAYED_LIST_STRING_SYNC, (Object) ""), ",")));
        }
        List list = (List) this.kBS.get();
        AppMethodBeat.m2505o(40948);
        return list;
    }

    /* renamed from: Ia */
    private synchronized boolean m55400Ia(String str) {
        boolean z;
        AppMethodBeat.m2504i(40949);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7421w("MicroMsg.F2fRcvVoiceListener", "illegal no: %s, not do play", str);
            AppMethodBeat.m2505o(40949);
            z = true;
        } else {
            List subList;
            List bgA = bgA();
            for (String equals : bgA()) {
                if (equals.equals(str)) {
                    C4990ab.m7417i("MicroMsg.F2fRcvVoiceListener", "has played tradeno: %s", str);
                    AppMethodBeat.m2505o(40949);
                    z = true;
                    break;
                }
            }
            bgA.add(str);
            if (bgA.size() > 10) {
                C4990ab.m7416i("MicroMsg.F2fRcvVoiceListener", "over max size, do remove");
                int size = bgA.size();
                subList = bgA.subList(size - 10, size);
            } else {
                subList = bgA;
            }
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_F2F_RCV_VOICE_PLAYED_LIST_STRING_SYNC, C5046bo.m7536c(subList, ","));
            AppMethodBeat.m2505o(40949);
            z = false;
        }
        return z;
    }

    /* renamed from: t */
    private static boolean m55416t(String str, byte[] bArr) {
        AppMethodBeat.m2504i(40950);
        C1720g.m3537RQ();
        if (!C1720g.m3536RP().isSDCardAvailable()) {
            C4990ab.m7416i("MicroMsg.F2fRcvVoiceListener", "sd card not available");
            AppMethodBeat.m2505o(40950);
            return false;
        } else if (C5730e.m8624b(str, bArr, bArr.length) == 0) {
            AppMethodBeat.m2505o(40950);
            return true;
        } else {
            AppMethodBeat.m2505o(40950);
            return false;
        }
    }

    public static boolean bgB() {
        AppMethodBeat.m2504i(40951);
        C4990ab.m7416i("MicroMsg.F2fRcvVoiceListener", "delete files");
        boolean N = C5730e.m8618N(kBK, true);
        AppMethodBeat.m2505o(40951);
        return N;
    }

    private synchronized void bgC() {
        AppMethodBeat.m2504i(40952);
        if (System.currentTimeMillis() - this.kBR > 10000) {
            C4990ab.m7417i("MicroMsg.F2fRcvVoiceListener", "last has outdate: %s", Long.valueOf(this.kBR));
            this.isPlaying = false;
        }
        if (this.isPlaying) {
            C4990ab.m7416i("MicroMsg.F2fRcvVoiceListener", "is playing, return");
            AppMethodBeat.m2505o(40952);
        } else {
            this.isPlaying = true;
            this.kBR = System.currentTimeMillis();
            final C33857b c33857b = (C33857b) this.kBO.poll();
            C1407g KK = C1407g.m2946KK();
            int streamMaxVolume = KK.getStreamMaxVolume(3);
            this.kBP = KK.getStreamVolume(3);
            this.kBQ = Math.round(((float) streamMaxVolume) * 0.5f);
            C4990ab.m7417i("MicroMsg.F2fRcvVoiceListener", "curVol: %s, maxVol: %s, minVol: %s", Integer.valueOf(this.kBP), Integer.valueOf(streamMaxVolume), Integer.valueOf(this.kBQ));
            boolean z;
            if (VERSION.SDK_INT >= 23) {
                C4990ab.m7417i("MicroMsg.F2fRcvVoiceListener", "isMute: %s", Boolean.valueOf(KK.eoY.isStreamMute(3)));
                z = r2;
            } else {
                z = false;
            }
            if (this.kBP == 0 || z) {
                C4990ab.m7416i("MicroMsg.F2fRcvVoiceListener", "music channel is mute");
                int i = c33857b != null ? c33857b.kBZ : 1;
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf(3);
                objArr[1] = c33857b != null ? c33857b.cva : "";
                objArr[2] = Integer.valueOf(5);
                objArr[3] = "";
                objArr[4] = Integer.valueOf(i);
                c7060h.mo8381e(14404, objArr);
            }
            if (this.kBP > 0 && this.kBP < this.kBQ && !z) {
                KK.mo4833bR(3, this.kBQ);
            }
            if (c33857b != null) {
                C4990ab.m7417i("MicroMsg.F2fRcvVoiceListener", "holder.offLine = %s", Boolean.valueOf(c33857b.kCb));
                if (!c33857b.kCb) {
                    int i2 = c33857b.kBZ;
                    if (C5046bo.isNullOrNil(c33857b.fileName)) {
                        this.kBM = C11417a.m19174a(C4996ah.getContext(), new OnCompletionListener() {
                            public final void onCompletion(MediaPlayer mediaPlayer) {
                                AppMethodBeat.m2504i(40937);
                                C4990ab.m7416i("MicroMsg.F2fRcvVoiceListener", "no need to play money this time");
                                C33858g.m55412f(C33858g.this);
                                C33858g.this.isPlaying = false;
                                C33858g.this.kBM = null;
                                C45815a.bgv();
                                C7060h.pYm.mo8381e(14404, Integer.valueOf(4), c33857b.cva, "", "", Integer.valueOf(c33857b.kBZ));
                                if (C33858g.this.kBO.isEmpty()) {
                                    C33858g.bgE();
                                    AppMethodBeat.m2505o(40937);
                                    return;
                                }
                                C33858g.m55414h(C33858g.this);
                                AppMethodBeat.m2505o(40937);
                            }
                        }, new OnErrorListener() {
                            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                AppMethodBeat.m2504i(40938);
                                C4990ab.m7412e("MicroMsg.F2fRcvVoiceListener", "no need play money error");
                                C33858g.m55412f(C33858g.this);
                                C33858g.this.isPlaying = false;
                                C33858g.this.kBM = null;
                                C7060h.pYm.mo8381e(14404, Integer.valueOf(3), c33857b.cva, Integer.valueOf(7), Integer.valueOf(i), Integer.valueOf(c33857b.kBZ));
                                AppMethodBeat.m2505o(40938);
                                return false;
                            }
                        });
                        C7060h.pYm.mo8378a(699, 2, 1, false);
                    } else {
                        C4990ab.m7417i("MicroMsg.F2fRcvVoiceListener", "play prefix voice: %d", Integer.valueOf(i2));
                        this.kBM = C11417a.m19174a(C4996ah.getContext(), new OnCompletionListener() {
                            public final void onCompletion(MediaPlayer mediaPlayer) {
                                AppMethodBeat.m2504i(40934);
                                C4990ab.m7416i("MicroMsg.F2fRcvVoiceListener", "start play money");
                                if (C33858g.this.kBM != null && C33858g.this.isPlaying && C33858g.this.kBN == null) {
                                    C33858g.m55406a(C33858g.this, c33857b);
                                } else {
                                    C4990ab.m7416i("MicroMsg.F2fRcvVoiceListener", "has played");
                                }
                                C33858g.this.kBM = null;
                                AppMethodBeat.m2505o(40934);
                            }
                        }, new OnErrorListener() {
                            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                AppMethodBeat.m2504i(40935);
                                C4990ab.m7412e("MicroMsg.F2fRcvVoiceListener", "prefix play error");
                                C33858g.this.isPlaying = false;
                                C33858g.this.kBM = null;
                                C33858g.m55412f(C33858g.this);
                                C7060h.pYm.mo8381e(14404, Integer.valueOf(3), c33857b.cva, Integer.valueOf(7), Integer.valueOf(i), Integer.valueOf(c33857b.kBZ));
                                if (C33858g.this.kBO.isEmpty()) {
                                    C33858g.bgE();
                                } else {
                                    C33858g.m55414h(C33858g.this);
                                }
                                AppMethodBeat.m2505o(40935);
                                return false;
                            }
                        });
                        if (this.kBM != null) {
                            C4990ab.m7417i("MicroMsg.F2fRcvVoiceListener", "prefix duration: %s", Integer.valueOf(this.kBM.getDuration()));
                            C5004al.m7442n(new C114163(), (long) (r0 + 1000));
                            AppMethodBeat.m2505o(40952);
                        }
                    }
                    AppMethodBeat.m2505o(40952);
                } else if (this.isPlaying && this.kBN == null) {
                    m55405a(c33857b);
                    AppMethodBeat.m2505o(40952);
                } else {
                    C4990ab.m7416i("MicroMsg.F2fRcvVoiceListener", "has played");
                    AppMethodBeat.m2505o(40952);
                }
            } else {
                this.isPlaying = false;
                AppMethodBeat.m2505o(40952);
            }
        }
    }

    /* renamed from: a */
    private void m55405a(final C33857b c33857b) {
        AppMethodBeat.m2504i(40953);
        this.kBN = C11417a.m19175a(c33857b.fileName, new OnCompletionListener() {
            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.m2504i(40939);
                C4990ab.m7416i("MicroMsg.F2fRcvVoiceListener", "play done");
                C33858g.this.isPlaying = false;
                C33858g.this.kBN = null;
                C33858g.m55412f(C33858g.this);
                if (C45815a.bgv().kBA) {
                    C7060h.pYm.mo8381e(14404, Integer.valueOf(1), c33857b.cva, "", "", Integer.valueOf(c33857b.kBZ));
                } else {
                    C7060h.pYm.mo8381e(14404, Integer.valueOf(2), c33857b.cva, "", "", Integer.valueOf(c33857b.kBZ));
                }
                if (C33858g.this.kBO.isEmpty()) {
                    C33858g.bgE();
                    AppMethodBeat.m2505o(40939);
                    return;
                }
                C33858g.m55414h(C33858g.this);
                AppMethodBeat.m2505o(40939);
            }
        }, new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.m2504i(40940);
                C4990ab.m7413e("MicroMsg.F2fRcvVoiceListener", "play money error: %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
                C33858g.this.isPlaying = false;
                C33858g.this.kBN = null;
                C7060h.pYm.mo8381e(14404, Integer.valueOf(3), c33857b.cva, Integer.valueOf(7), Integer.valueOf(i), Integer.valueOf(c33857b.kBZ));
                C33858g.m55412f(C33858g.this);
                if (C33858g.this.kBO.isEmpty()) {
                    C33858g.bgE();
                } else {
                    C33858g.m55414h(C33858g.this);
                }
                AppMethodBeat.m2505o(40940);
                return false;
            }
        });
        AppMethodBeat.m2505o(40953);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(40954);
        C4990ab.m7416i("MicroMsg.F2fRcvVoiceListener", "errType:" + i + " errCode:" + i2 + " errMsg:" + str + " scenetype:" + c1207m.getType());
        if (c1207m instanceof C45816i) {
            C45816i c45816i = (C45816i) c1207m;
            if (i == 0 && i2 == 0) {
                C4990ab.m7417i("MicroMsg.F2fRcvVoiceListener", "overtime: %s retcode: %s", Integer.valueOf(c45816i.kCf.vWk), Integer.valueOf(c45816i.kCf.kCl));
                if (c45816i.kCf.vWk == 1) {
                    C4990ab.m7421w("MicroMsg.F2fRcvVoiceListener", "skip over 10min: %s", Long.valueOf(c45816i.cvc));
                    C7060h.pYm.mo8381e(14404, Integer.valueOf(3), c45816i.cva, Integer.valueOf(1), "", Integer.valueOf(1));
                    AppMethodBeat.m2505o(40954);
                    return;
                } else if (c45816i.kCf.kCl == 0) {
                    m55404a(1, c45816i.kCf.vWj.f1226wR, c45816i.kCf.vWi, c45816i.cva, c45816i.kCf.vWk, false);
                    C7060h.pYm.mo8381e(15763, c45816i.cva, Integer.valueOf(1), Integer.valueOf(C33858g.m55417tH(c45816i.cvd)), Long.valueOf(c45816i.kCg), Integer.valueOf(C33858g.bgD()));
                    AppMethodBeat.m2505o(40954);
                    return;
                } else if (c45816i.kCf.kCl <= 100) {
                    C4990ab.m7416i("MicroMsg.F2fRcvVoiceListener", "play default sound only");
                    m55407ar(1, c45816i.cva);
                    C7060h.pYm.mo8381e(15763, c45816i.cva, Integer.valueOf(2), Integer.valueOf(C33858g.m55417tH(c45816i.cvd)), Long.valueOf(c45816i.kCg), Integer.valueOf(C33858g.bgD()));
                    AppMethodBeat.m2505o(40954);
                    return;
                } else {
                    C4990ab.m7420w("MicroMsg.F2fRcvVoiceListener", "retcode > 100, don't play");
                    C7060h.pYm.mo8381e(14404, Integer.valueOf(3), c45816i.cva, Integer.valueOf(2), "", Integer.valueOf(1));
                    C7060h.pYm.mo8381e(15763, c45816i.cva, Integer.valueOf(2), Integer.valueOf(C33858g.m55417tH(c45816i.cvd)), Long.valueOf(c45816i.kCg), Integer.valueOf(C33858g.bgD()));
                    AppMethodBeat.m2505o(40954);
                    return;
                }
            }
            C4990ab.m7413e("MicroMsg.F2fRcvVoiceListener", "net error: %s", c45816i);
            m55407ar(1, c45816i.cva);
            C7060h.pYm.mo8381e(15763, c45816i.cva, Integer.valueOf(2), Integer.valueOf(C33858g.m55417tH(c45816i.cvd)), Long.valueOf(c45816i.kCg), Integer.valueOf(C33858g.bgD()));
            C7060h.pYm.mo8381e(14404, Integer.valueOf(3), c45816i.cva, Integer.valueOf(3), "", Integer.valueOf(1));
            AppMethodBeat.m2505o(40954);
            return;
        }
        if (c1207m instanceof C38806n) {
            C38806n c38806n = (C38806n) c1207m;
            if (i != 0 || i2 != 0) {
                C4990ab.m7413e("MicroMsg.F2fRcvVoiceListener", "net error: %s", c38806n);
                C7060h.pYm.mo8381e(14404, Integer.valueOf(3), c38806n.cva, Integer.valueOf(3), "", Integer.valueOf(2));
            } else if (c38806n.kCB.kCl == 0) {
                C5728b c5728b = new C5728b(kBK);
                if (c5728b.exists() || c5728b.mkdirs()) {
                    String str2 = kBK + UUID.randomUUID().toString() + ".tmp";
                    C4990ab.m7417i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", str2);
                    if (C33858g.m55416t(str2, c38806n.kCB.vWj.f1226wR)) {
                        C33857b c33857b = new C33857b(this, (byte) 0);
                        c33857b.fileName = str2;
                        c33857b.cAO = c38806n.kCB.vWi;
                        c33857b.kBZ = 2;
                        this.kBO.add(c33857b);
                        bgC();
                        AppMethodBeat.m2505o(40954);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.F2fRcvVoiceListener", "save file fail");
                    AppMethodBeat.m2505o(40954);
                    return;
                }
                C4990ab.m7416i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
                AppMethodBeat.m2505o(40954);
                return;
            } else {
                C7060h.pYm.mo8381e(14404, Integer.valueOf(3), c38806n.cva, Integer.valueOf(2), "", Integer.valueOf(2));
                AppMethodBeat.m2505o(40954);
                return;
            }
        }
        AppMethodBeat.m2505o(40954);
    }

    /* renamed from: a */
    public final void mo35507a(int i, String str, String str2, String str3, int i2, String str4, byte[] bArr) {
        AppMethodBeat.m2504i(40955);
        C4990ab.m7417i("MicroMsg.F2fRcvVoiceListener", "errorCode:%s outTradeNo:%s type:%s content:%s packId:%s overtimeFlag:%s", Integer.valueOf(i), str, str2, str3, str4, Integer.valueOf(0));
        int Ib = C33858g.m55401Ib(str2);
        if (i < 0) {
            m55407ar(Ib, str);
            m55403a(6, str, Ib, str3, i2, str4, 9);
            AppMethodBeat.m2505o(40955);
            return;
        }
        m55404a(Ib, bArr, 1, str, 0, true);
        m55403a(5, str, Ib, str3, i2, str4, 0);
        AppMethodBeat.m2505o(40955);
    }

    /* renamed from: a */
    private void m55404a(int i, byte[] bArr, int i2, String str, int i3, boolean z) {
        AppMethodBeat.m2504i(40956);
        C5728b c5728b = new C5728b(kBK);
        if (c5728b.exists() || c5728b.mkdirs()) {
            String str2 = kBK + UUID.randomUUID().toString() + ".tmp";
            C4990ab.m7417i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", str2);
            if (C33858g.m55416t(str2, bArr)) {
                C33857b c33857b = new C33857b(this, (byte) 0);
                c33857b.fileName = str2;
                c33857b.cAO = i2;
                c33857b.kBZ = i;
                c33857b.cva = str;
                c33857b.kCa = i3;
                c33857b.kCb = z;
                this.kBO.add(c33857b);
                bgC();
                AppMethodBeat.m2505o(40956);
                return;
            }
            C4990ab.m7416i("MicroMsg.F2fRcvVoiceListener", "save file fail");
            AppMethodBeat.m2505o(40956);
            return;
        }
        C4990ab.m7416i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
        AppMethodBeat.m2505o(40956);
    }

    /* renamed from: ar */
    private void m55407ar(int i, String str) {
        AppMethodBeat.m2504i(40957);
        C4990ab.m7416i("MicroMsg.F2fRcvVoiceListener", "play default sound only");
        C33857b c33857b = new C33857b(this, (byte) 0);
        c33857b.kBZ = i;
        c33857b.cva = str;
        this.kBO.add(c33857b);
        bgC();
        AppMethodBeat.m2505o(40957);
    }

    /* renamed from: tH */
    private static int m55417tH(int i) {
        if (i == 1) {
            return 3;
        }
        return 2;
    }

    /* renamed from: Ib */
    private static int m55401Ib(String str) {
        AppMethodBeat.m2504i(40958);
        int i = 0;
        if (str.equals("wx_f2f")) {
            i = 1;
        } else if (str.equals("wx_md")) {
            i = 2;
        }
        AppMethodBeat.m2505o(40958);
        return i;
    }

    /* renamed from: a */
    private void m55403a(int i, String str, int i2, String str2, int i3, String str3, int i4) {
        AppMethodBeat.m2504i(40959);
        this.kBT = new C18439bf();
        this.kBT.cVR = (long) i;
        this.kBT.mo33700fV(str);
        if (!C5046bo.m7563gW(i4, 0)) {
            this.kBT.dbV = (long) i4;
        }
        this.kBT.dbX = (long) i2;
        this.kBT.mo33701fW(str2);
        this.kBT.dca = (long) i3;
        if (C5046bo.m7563gW(i, 6)) {
            this.kBT.mo33702fX(str3);
        }
        this.kBT.ajK();
        AppMethodBeat.m2505o(40959);
    }

    private static int bgD() {
        AppMethodBeat.m2504i(40960);
        if (C1407g.m2946KK().mo4819KP()) {
            AppMethodBeat.m2505o(40960);
            return 1;
        }
        AppMethodBeat.m2505o(40960);
        return 0;
    }

    /* renamed from: f */
    static /* synthetic */ void m55412f(C33858g c33858g) {
        AppMethodBeat.m2504i(40963);
        C4990ab.m7417i("MicroMsg.F2fRcvVoiceListener", "reset user vol: %s", Integer.valueOf(c33858g.kBP));
        C1407g.m2946KK().mo4833bR(3, c33858g.kBP);
        AppMethodBeat.m2505o(40963);
    }
}
