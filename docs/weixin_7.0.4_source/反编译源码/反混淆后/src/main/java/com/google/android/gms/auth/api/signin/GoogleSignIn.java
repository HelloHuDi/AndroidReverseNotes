package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.p057v4.app.Fragment;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.auth.api.signin.internal.zzi;
import com.google.android.gms.auth.api.signin.internal.zzq;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public final class GoogleSignIn {
    private GoogleSignIn() {
    }

    public static GoogleSignInAccount getAccountForExtension(Context context, GoogleSignInOptionsExtension googleSignInOptionsExtension) {
        AppMethodBeat.m2504i(50377);
        Preconditions.checkNotNull(context, "please provide a valid Context object");
        Preconditions.checkNotNull(googleSignInOptionsExtension, "please provide valid GoogleSignInOptionsExtension");
        GoogleSignInAccount lastSignedInAccount = getLastSignedInAccount(context);
        if (lastSignedInAccount == null) {
            lastSignedInAccount = GoogleSignInAccount.createDefault();
        }
        lastSignedInAccount = lastSignedInAccount.requestExtraScopes(zzd(googleSignInOptionsExtension.getImpliedScopes()));
        AppMethodBeat.m2505o(50377);
        return lastSignedInAccount;
    }

    public static GoogleSignInAccount getAccountForScopes(Context context, Scope scope, Scope... scopeArr) {
        AppMethodBeat.m2504i(50376);
        Preconditions.checkNotNull(context, "please provide a valid Context object");
        Preconditions.checkNotNull(scope, "please provide at least one valid scope");
        GoogleSignInAccount lastSignedInAccount = getLastSignedInAccount(context);
        if (lastSignedInAccount == null) {
            lastSignedInAccount = GoogleSignInAccount.createDefault();
        }
        lastSignedInAccount.requestExtraScopes(scope);
        lastSignedInAccount.requestExtraScopes(scopeArr);
        AppMethodBeat.m2505o(50376);
        return lastSignedInAccount;
    }

    public static GoogleSignInClient getClient(Activity activity, GoogleSignInOptions googleSignInOptions) {
        AppMethodBeat.m2504i(50373);
        GoogleSignInClient googleSignInClient = new GoogleSignInClient(activity, (GoogleSignInOptions) Preconditions.checkNotNull(googleSignInOptions));
        AppMethodBeat.m2505o(50373);
        return googleSignInClient;
    }

    public static GoogleSignInClient getClient(Context context, GoogleSignInOptions googleSignInOptions) {
        AppMethodBeat.m2504i(50372);
        GoogleSignInClient googleSignInClient = new GoogleSignInClient(context, (GoogleSignInOptions) Preconditions.checkNotNull(googleSignInOptions));
        AppMethodBeat.m2505o(50372);
        return googleSignInClient;
    }

    public static GoogleSignInAccount getLastSignedInAccount(Context context) {
        AppMethodBeat.m2504i(50375);
        GoogleSignInAccount zzo = zzq.zze(context).zzo();
        AppMethodBeat.m2505o(50375);
        return zzo;
    }

    public static Task<GoogleSignInAccount> getSignedInAccountFromIntent(Intent intent) {
        AppMethodBeat.m2504i(50374);
        GoogleSignInResult signInResultFromIntent = zzi.getSignInResultFromIntent(intent);
        Task forException;
        if (signInResultFromIntent == null) {
            forException = Tasks.forException(ApiExceptionUtil.fromStatus(Status.RESULT_INTERNAL_ERROR));
            AppMethodBeat.m2505o(50374);
            return forException;
        } else if (!signInResultFromIntent.getStatus().isSuccess() || signInResultFromIntent.getSignInAccount() == null) {
            forException = Tasks.forException(ApiExceptionUtil.fromStatus(signInResultFromIntent.getStatus()));
            AppMethodBeat.m2505o(50374);
            return forException;
        } else {
            forException = Tasks.forResult(signInResultFromIntent.getSignInAccount());
            AppMethodBeat.m2505o(50374);
            return forException;
        }
    }

    public static boolean hasPermissions(GoogleSignInAccount googleSignInAccount, GoogleSignInOptionsExtension googleSignInOptionsExtension) {
        AppMethodBeat.m2504i(50378);
        Preconditions.checkNotNull(googleSignInOptionsExtension, "Please provide a non-null GoogleSignInOptionsExtension");
        boolean hasPermissions = hasPermissions(googleSignInAccount, zzd(googleSignInOptionsExtension.getImpliedScopes()));
        AppMethodBeat.m2505o(50378);
        return hasPermissions;
    }

    public static boolean hasPermissions(GoogleSignInAccount googleSignInAccount, Scope... scopeArr) {
        AppMethodBeat.m2504i(50379);
        if (googleSignInAccount == null) {
            AppMethodBeat.m2505o(50379);
            return false;
        }
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, scopeArr);
        boolean containsAll = googleSignInAccount.getGrantedScopes().containsAll(hashSet);
        AppMethodBeat.m2505o(50379);
        return containsAll;
    }

    public static void requestPermissions(Activity activity, int i, GoogleSignInAccount googleSignInAccount, GoogleSignInOptionsExtension googleSignInOptionsExtension) {
        AppMethodBeat.m2504i(50380);
        Preconditions.checkNotNull(activity, "Please provide a non-null Activity");
        Preconditions.checkNotNull(googleSignInOptionsExtension, "Please provide a non-null GoogleSignInOptionsExtension");
        requestPermissions(activity, i, googleSignInAccount, zzd(googleSignInOptionsExtension.getImpliedScopes()));
        AppMethodBeat.m2505o(50380);
    }

    public static void requestPermissions(Activity activity, int i, GoogleSignInAccount googleSignInAccount, Scope... scopeArr) {
        AppMethodBeat.m2504i(50382);
        Preconditions.checkNotNull(activity, "Please provide a non-null Activity");
        Preconditions.checkNotNull(scopeArr, "Please provide at least one scope");
        activity.startActivityForResult(zzd(activity, googleSignInAccount, scopeArr), i);
        AppMethodBeat.m2505o(50382);
    }

    public static void requestPermissions(Fragment fragment, int i, GoogleSignInAccount googleSignInAccount, GoogleSignInOptionsExtension googleSignInOptionsExtension) {
        AppMethodBeat.m2504i(50381);
        Preconditions.checkNotNull(fragment, "Please provide a non-null Fragment");
        Preconditions.checkNotNull(googleSignInOptionsExtension, "Please provide a non-null GoogleSignInOptionsExtension");
        requestPermissions(fragment, i, googleSignInAccount, zzd(googleSignInOptionsExtension.getImpliedScopes()));
        AppMethodBeat.m2505o(50381);
    }

    public static void requestPermissions(Fragment fragment, int i, GoogleSignInAccount googleSignInAccount, Scope... scopeArr) {
        AppMethodBeat.m2504i(50383);
        Preconditions.checkNotNull(fragment, "Please provide a non-null Fragment");
        Preconditions.checkNotNull(scopeArr, "Please provide at least one scope");
        fragment.startActivityForResult(zzd(fragment.getActivity(), googleSignInAccount, scopeArr), i);
        AppMethodBeat.m2505o(50383);
    }

    private static Intent zzd(Activity activity, GoogleSignInAccount googleSignInAccount, Scope... scopeArr) {
        AppMethodBeat.m2504i(50384);
        Builder builder = new Builder();
        if (scopeArr.length > 0) {
            builder.requestScopes(scopeArr[0], scopeArr);
        }
        if (!(googleSignInAccount == null || TextUtils.isEmpty(googleSignInAccount.getEmail()))) {
            builder.setAccountName(googleSignInAccount.getEmail());
        }
        Intent signInIntent = new GoogleSignInClient(activity, builder.build()).getSignInIntent();
        AppMethodBeat.m2505o(50384);
        return signInIntent;
    }

    private static Scope[] zzd(List<Scope> list) {
        AppMethodBeat.m2504i(50385);
        Scope[] scopeArr;
        if (list == null) {
            scopeArr = new Scope[0];
            AppMethodBeat.m2505o(50385);
            return scopeArr;
        }
        scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
        AppMethodBeat.m2505o(50385);
        return scopeArr;
    }
}
