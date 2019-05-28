package com.tencent.p177mm.plugin.music.p463f.p465b;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.google.android.exoplayer2.p1585d.C41599b;
import com.google.android.exoplayer2.p1585d.C45028a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.rtmp.sharp.jni.QLog;
import java.text.NumberFormat;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.music.f.b.a */
public final class C28566a {
    private static final NumberFormat oNW;

    /* renamed from: com.tencent.mm.plugin.music.f.b.a$1 */
    static class C35281 implements C45028a {
        C35281() {
        }

        /* renamed from: i */
        public final void mo8023i(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(137655);
            C4990ab.m7417i(str, str2, objArr);
            AppMethodBeat.m2505o(137655);
        }

        /* renamed from: w */
        public final void mo8024w(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(137656);
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(137656);
        }

        /* renamed from: e */
        public final void mo8022e(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(137657);
            C4990ab.m7413e(str, str2, objArr);
            AppMethodBeat.m2505o(137657);
        }
    }

    static {
        AppMethodBeat.m2504i(137661);
        NumberFormat instance = NumberFormat.getInstance(Locale.US);
        oNW = instance;
        instance.setMinimumFractionDigits(2);
        oNW.setMaximumFractionDigits(2);
        oNW.setGroupingUsed(false);
        AppMethodBeat.m2505o(137661);
    }

    public static void bUI() {
        AppMethodBeat.m2504i(137658);
        C41599b.DEBUG = false;
        C41599b.m72862a(new C35281());
        AppMethodBeat.m2505o(137658);
    }

    /* renamed from: jo */
    public static String m45372jo(long j) {
        AppMethodBeat.m2504i(137659);
        String str;
        if (j == -9223372036854775807L) {
            str = "?";
            AppMethodBeat.m2505o(137659);
            return str;
        }
        str = oNW.format((double) (((float) j) / 1000.0f));
        AppMethodBeat.m2505o(137659);
        return str;
    }

    /* renamed from: zT */
    public static String m45373zT(int i) {
        switch (i) {
            case 1:
                return "I";
            case 2:
                return "B";
            case 3:
                return "R";
            case 4:
                return QLog.TAG_REPORTLEVEL_USER;
            default:
                return "?";
        }
    }

    /* renamed from: a */
    public static void m45371a(Metadata metadata, String str) {
        AppMethodBeat.m2504i(137660);
        for (Entry entry : metadata.beW) {
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                C4990ab.m7410d("MicroMsg.ExoPlayer", str + String.format("%s: value=%s", new Object[]{textInformationFrame.f17724id, textInformationFrame.value}));
            } else if (entry instanceof UrlLinkFrame) {
                UrlLinkFrame urlLinkFrame = (UrlLinkFrame) entry;
                C4990ab.m7410d("MicroMsg.ExoPlayer", str + String.format("%s: url=%s", new Object[]{urlLinkFrame.f17724id, urlLinkFrame.url}));
            } else if (entry instanceof PrivFrame) {
                PrivFrame privFrame = (PrivFrame) entry;
                C4990ab.m7410d("MicroMsg.ExoPlayer", str + String.format("%s: owner=%s", new Object[]{privFrame.f17724id, privFrame.bfz}));
            } else if (entry instanceof GeobFrame) {
                GeobFrame geobFrame = (GeobFrame) entry;
                C4990ab.m7410d("MicroMsg.ExoPlayer", str + String.format("%s: mimeType=%s, filename=%s, description=%s", new Object[]{geobFrame.f17724id, geobFrame.mimeType, geobFrame.filename, geobFrame.description}));
            } else if (entry instanceof ApicFrame) {
                ApicFrame apicFrame = (ApicFrame) entry;
                C4990ab.m7410d("MicroMsg.ExoPlayer", str + String.format("%s: mimeType=%s, description=%s", new Object[]{apicFrame.f17724id, apicFrame.mimeType, apicFrame.description}));
            } else if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                C4990ab.m7410d("MicroMsg.ExoPlayer", str + String.format("%s: language=%s, description=%s", new Object[]{commentFrame.f17724id, commentFrame.aOt, commentFrame.description}));
            } else if (entry instanceof Id3Frame) {
                Id3Frame id3Frame = (Id3Frame) entry;
                C4990ab.m7410d("MicroMsg.ExoPlayer", str + String.format("%s", new Object[]{id3Frame.f17724id}));
            } else if (entry instanceof EventMessage) {
                EventMessage eventMessage = (EventMessage) entry;
                C4990ab.m7410d("MicroMsg.ExoPlayer", str + String.format("EMSG: scheme=%s, id=%d, value=%s", new Object[]{eventMessage.bfh, Long.valueOf(eventMessage.f17723id), eventMessage.value}));
            }
        }
        AppMethodBeat.m2505o(137660);
    }
}
