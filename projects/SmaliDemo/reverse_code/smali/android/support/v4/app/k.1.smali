.class public Landroid/support/v4/app/k;
.super Landroid/support/v4/app/X;
.source ""

# interfaces
.implements Landroid/arch/lifecycle/t;
.implements Landroid/support/v4/app/a$a;
.implements Landroid/support/v4/app/a$c;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v4/app/k$a;,
        Landroid/support/v4/app/k$b;
    }
.end annotation


# instance fields
.field final c:Landroid/os/Handler;

.field final d:Landroid/support/v4/app/m;

.field private e:Landroid/arch/lifecycle/s;

.field f:Z

.field g:Z

.field h:Z

.field i:Z

.field j:Z

.field k:I

.field l:La/b/c/f/n;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "La/b/c/f/n<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 68
    invoke-direct {p0}, Landroid/support/v4/app/X;-><init>()V

    .line 82
    new-instance v0, Landroid/support/v4/app/j;

    invoke-direct {v0, p0}, Landroid/support/v4/app/j;-><init>(Landroid/support/v4/app/k;)V

    iput-object v0, p0, Landroid/support/v4/app/k;->c:Landroid/os/Handler;

    .line 96
    new-instance v0, Landroid/support/v4/app/k$a;

    invoke-direct {v0, p0}, Landroid/support/v4/app/k$a;-><init>(Landroid/support/v4/app/k;)V

    invoke-static {v0}, Landroid/support/v4/app/m;->a(Landroid/support/v4/app/n;)Landroid/support/v4/app/m;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    .line 102
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/k;->h:Z

    .line 957
    return-void
.end method

.method static a(I)V
    .locals 2
    .param p0, "requestCode"    # I

    .line 805
    const/high16 v0, -0x10000

    and-int/2addr v0, p0

    if-nez v0, :cond_0

    .line 808
    return-void

    .line 806
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Can only use lower 16 bits for requestCode"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private static a(Landroid/support/v4/app/o;Landroid/arch/lifecycle/d$b;)Z
    .locals 6
    .param p0, "manager"    # Landroid/support/v4/app/o;
    .param p1, "state"    # Landroid/arch/lifecycle/d$b;

    .line 1056
    const/4 v0, 0x0

    .line 1057
    .local v0, "hadNotMarked":Z
    invoke-virtual {p0}, Landroid/support/v4/app/o;->a()Ljava/util/List;

    move-result-object v1

    .line 1058
    .local v1, "fragments":Ljava/util/Collection;, "Ljava/util/Collection<Landroid/support/v4/app/Fragment;>;"
    invoke-interface {v1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/support/v4/app/i;

    .line 1059
    .local v3, "fragment":Landroid/support/v4/app/i;
    if-nez v3, :cond_0

    .line 1060
    goto :goto_0

    .line 1062
    :cond_0
    invoke-virtual {v3}, Landroid/support/v4/app/i;->a()Landroid/arch/lifecycle/d;

    move-result-object v4

    invoke-virtual {v4}, Landroid/arch/lifecycle/d;->a()Landroid/arch/lifecycle/d$b;

    move-result-object v4

    sget-object v5, Landroid/arch/lifecycle/d$b;->d:Landroid/arch/lifecycle/d$b;

    invoke-virtual {v4, v5}, Landroid/arch/lifecycle/d$b;->a(Landroid/arch/lifecycle/d$b;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 1063
    iget-object v4, v3, Landroid/support/v4/app/i;->U:Landroid/arch/lifecycle/h;

    invoke-virtual {v4, p1}, Landroid/arch/lifecycle/h;->a(Landroid/arch/lifecycle/d$b;)V

    .line 1064
    const/4 v0, 0x1

    .line 1067
    :cond_1
    invoke-virtual {v3}, Landroid/support/v4/app/i;->O()Landroid/support/v4/app/o;

    move-result-object v4

    .line 1068
    .local v4, "childFragmentManager":Landroid/support/v4/app/o;
    if-eqz v4, :cond_2

    .line 1069
    invoke-static {v4, p1}, Landroid/support/v4/app/k;->a(Landroid/support/v4/app/o;Landroid/arch/lifecycle/d$b;)Z

    move-result v5

    or-int/2addr v0, v5

    .line 1071
    .end local v3    # "fragment":Landroid/support/v4/app/i;
    .end local v4    # "childFragmentManager":Landroid/support/v4/app/o;
    :cond_2
    goto :goto_0

    .line 1072
    :cond_3
    return v0
.end method

.method private h()V
    .locals 2

    .line 1051
    :goto_0
    invoke-virtual {p0}, Landroid/support/v4/app/k;->d()Landroid/support/v4/app/o;

    move-result-object v0

    sget-object v1, Landroid/arch/lifecycle/d$b;->c:Landroid/arch/lifecycle/d$b;

    invoke-static {v0, v1}, Landroid/support/v4/app/k;->a(Landroid/support/v4/app/o;Landroid/arch/lifecycle/d$b;)Z

    move-result v0

    .line 1052
    .local v0, "reiterate":Z
    if-nez v0, :cond_0

    .line 1053
    return-void

    .line 1052
    :cond_0
    goto :goto_0
.end method


# virtual methods
.method public a()Landroid/arch/lifecycle/d;
    .locals 1

    .line 324
    invoke-super {p0}, Landroid/support/v4/app/X;->a()Landroid/arch/lifecycle/d;

    move-result-object v0

    return-object v0
.end method

.method final a(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 1
    .param p1, "parent"    # Landroid/view/View;
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "context"    # Landroid/content/Context;
    .param p4, "attrs"    # Landroid/util/AttributeSet;

    .line 405
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0, p1, p2, p3, p4}, Landroid/support/v4/app/m;->a(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public a(Landroid/support/v4/app/i;)V
    .locals 0
    .param p1, "fragment"    # Landroid/support/v4/app/i;

    .line 722
    return-void
.end method

.method protected a(Landroid/view/View;Landroid/view/Menu;)Z
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "menu"    # Landroid/view/Menu;

    .line 559
    const/4 v0, 0x0

    invoke-super {p0, v0, p1, p2}, Landroid/app/Activity;->onPreparePanel(ILandroid/view/View;Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method public b()Landroid/arch/lifecycle/s;
    .locals 2

    .line 299
    invoke-virtual {p0}, Landroid/app/Activity;->getApplication()Landroid/app/Application;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 303
    iget-object v0, p0, Landroid/support/v4/app/k;->e:Landroid/arch/lifecycle/s;

    if-nez v0, :cond_1

    .line 304
    nop

    .line 305
    invoke-virtual {p0}, Landroid/app/Activity;->getLastNonConfigurationInstance()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/k$b;

    .line 306
    .local v0, "nc":Landroid/support/v4/app/k$b;
    if-eqz v0, :cond_0

    .line 308
    iget-object v1, v0, Landroid/support/v4/app/k$b;->b:Landroid/arch/lifecycle/s;

    iput-object v1, p0, Landroid/support/v4/app/k;->e:Landroid/arch/lifecycle/s;

    .line 310
    :cond_0
    iget-object v1, p0, Landroid/support/v4/app/k;->e:Landroid/arch/lifecycle/s;

    if-nez v1, :cond_1

    .line 311
    new-instance v1, Landroid/arch/lifecycle/s;

    invoke-direct {v1}, Landroid/arch/lifecycle/s;-><init>()V

    iput-object v1, p0, Landroid/support/v4/app/k;->e:Landroid/arch/lifecycle/s;

    .line 314
    .end local v0    # "nc":Landroid/support/v4/app/k$b;
    :cond_1
    iget-object v0, p0, Landroid/support/v4/app/k;->e:Landroid/arch/lifecycle/s;

    return-object v0

    .line 300
    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Your activity is not yet attached to the Application instance. You can\'t request ViewModel before onCreate call."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public d()Landroid/support/v4/app/o;
    .locals 1

    .line 729
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0}, Landroid/support/v4/app/m;->j()Landroid/support/v4/app/o;

    move-result-object v0

    return-object v0
.end method

.method public dump(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    .locals 2
    .param p1, "prefix"    # Ljava/lang/String;
    .param p2, "fd"    # Ljava/io/FileDescriptor;
    .param p3, "writer"    # Ljava/io/PrintWriter;
    .param p4, "args"    # [Ljava/lang/String;

    .line 693
    invoke-super {p0, p1, p2, p3, p4}, Landroid/app/Activity;->dump(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V

    .line 694
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "Local FragmentActivity "

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 695
    invoke-static {p0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 696
    const-string v0, " State:"

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    .line 697
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "  "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 698
    .local v0, "innerPrefix":Ljava/lang/String;
    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v1, "mCreated="

    invoke-virtual {p3, v1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 699
    iget-boolean v1, p0, Landroid/support/v4/app/k;->f:Z

    invoke-virtual {p3, v1}, Ljava/io/PrintWriter;->print(Z)V

    const-string v1, " mResumed="

    invoke-virtual {p3, v1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 700
    iget-boolean v1, p0, Landroid/support/v4/app/k;->g:Z

    invoke-virtual {p3, v1}, Ljava/io/PrintWriter;->print(Z)V

    const-string v1, " mStopped="

    invoke-virtual {p3, v1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 701
    iget-boolean v1, p0, Landroid/support/v4/app/k;->h:Z

    invoke-virtual {p3, v1}, Ljava/io/PrintWriter;->print(Z)V

    .line 703
    invoke-virtual {p0}, Landroid/app/Activity;->getApplication()Landroid/app/Application;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 704
    invoke-static {p0}, Landroid/support/v4/app/Q;->a(Landroid/arch/lifecycle/f;)Landroid/support/v4/app/Q;

    move-result-object v1

    invoke-virtual {v1, v0, p2, p3, p4}, Landroid/support/v4/app/Q;->a(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V

    .line 706
    :cond_0
    iget-object v1, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v1}, Landroid/support/v4/app/m;->j()Landroid/support/v4/app/o;

    move-result-object v1

    invoke-virtual {v1, p1, p2, p3, p4}, Landroid/support/v4/app/o;->a(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V

    .line 707
    return-void
.end method

.method protected e()V
    .locals 1

    .line 538
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0}, Landroid/support/v4/app/m;->f()V

    .line 539
    return-void
.end method

.method public f()Ljava/lang/Object;
    .locals 1

    .line 653
    const/4 v0, 0x0

    return-object v0
.end method

.method public g()V
    .locals 0
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 678
    invoke-virtual {p0}, Landroid/app/Activity;->invalidateOptionsMenu()V

    .line 679
    return-void
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 6
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .line 145
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0}, Landroid/support/v4/app/m;->k()V

    .line 146
    shr-int/lit8 v0, p1, 0x10

    .line 147
    .local v0, "requestIndex":I
    if-eqz v0, :cond_2

    .line 148
    add-int/lit8 v0, v0, -0x1

    .line 150
    iget-object v1, p0, Landroid/support/v4/app/k;->l:La/b/c/f/n;

    invoke-virtual {v1, v0}, La/b/c/f/n;->b(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 151
    .local v1, "who":Ljava/lang/String;
    iget-object v2, p0, Landroid/support/v4/app/k;->l:La/b/c/f/n;

    invoke-virtual {v2, v0}, La/b/c/f/n;->d(I)V

    .line 152
    const-string v2, "FragmentActivity"

    if-nez v1, :cond_0

    .line 153
    const-string v3, "Activity result delivered for unknown Fragment."

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 154
    return-void

    .line 156
    :cond_0
    iget-object v3, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v3, v1}, Landroid/support/v4/app/m;->a(Ljava/lang/String;)Landroid/support/v4/app/i;

    move-result-object v3

    .line 157
    .local v3, "targetFragment":Landroid/support/v4/app/i;
    if-nez v3, :cond_1

    .line 158
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Activity result no fragment exists for who: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 160
    :cond_1
    const v2, 0xffff

    and-int/2addr v2, p1

    invoke-virtual {v3, v2, p2, p3}, Landroid/support/v4/app/i;->a(IILandroid/content/Intent;)V

    .line 162
    :goto_0
    return-void

    .line 166
    .end local v1    # "who":Ljava/lang/String;
    .end local v3    # "targetFragment":Landroid/support/v4/app/i;
    :cond_2
    invoke-static {}, Landroid/support/v4/app/a;->a()Landroid/support/v4/app/a$b;

    move-result-object v1

    .line 167
    .local v1, "delegate":Landroid/support/v4/app/a$b;
    if-eqz v1, :cond_3

    invoke-interface {v1, p0, p1, p2, p3}, Landroid/support/v4/app/a$b;->a(Landroid/app/Activity;IILandroid/content/Intent;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 169
    return-void

    .line 172
    :cond_3
    invoke-super {p0, p1, p2, p3}, Landroid/app/Activity;->onActivityResult(IILandroid/content/Intent;)V

    .line 173
    return-void
.end method

.method public onBackPressed()V
    .locals 4

    .line 181
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0}, Landroid/support/v4/app/m;->j()Landroid/support/v4/app/o;

    move-result-object v0

    .line 182
    .local v0, "fragmentManager":Landroid/support/v4/app/o;
    invoke-virtual {v0}, Landroid/support/v4/app/o;->b()Z

    move-result v1

    .line 183
    .local v1, "isStateSaved":Z
    if-eqz v1, :cond_0

    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x19

    if-gt v2, v3, :cond_0

    .line 188
    return-void

    .line 190
    :cond_0
    if-nez v1, :cond_1

    invoke-virtual {v0}, Landroid/support/v4/app/o;->c()Z

    move-result v2

    if-nez v2, :cond_2

    .line 191
    :cond_1
    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    .line 193
    :cond_2
    return-void
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 1
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .line 284
    invoke-super {p0, p1}, Landroid/app/Activity;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 285
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0}, Landroid/support/v4/app/m;->k()V

    .line 286
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/m;->a(Landroid/content/res/Configuration;)V

    .line 287
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 8
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 333
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/m;->a(Landroid/support/v4/app/i;)V

    .line 335
    invoke-super {p0, p1}, Landroid/support/v4/app/X;->onCreate(Landroid/os/Bundle;)V

    .line 337
    nop

    .line 338
    invoke-virtual {p0}, Landroid/app/Activity;->getLastNonConfigurationInstance()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/k$b;

    .line 339
    .local v0, "nc":Landroid/support/v4/app/k$b;
    if-eqz v0, :cond_0

    iget-object v2, v0, Landroid/support/v4/app/k$b;->b:Landroid/arch/lifecycle/s;

    if-eqz v2, :cond_0

    iget-object v3, p0, Landroid/support/v4/app/k;->e:Landroid/arch/lifecycle/s;

    if-nez v3, :cond_0

    .line 340
    iput-object v2, p0, Landroid/support/v4/app/k;->e:Landroid/arch/lifecycle/s;

    .line 342
    :cond_0
    if-eqz p1, :cond_4

    .line 343
    const-string v2, "android:support:fragments"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v2

    .line 344
    .local v2, "p":Landroid/os/Parcelable;
    iget-object v3, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    if-eqz v0, :cond_1

    iget-object v1, v0, Landroid/support/v4/app/k$b;->c:Landroid/support/v4/app/w;

    :cond_1
    invoke-virtual {v3, v2, v1}, Landroid/support/v4/app/m;->a(Landroid/os/Parcelable;Landroid/support/v4/app/w;)V

    .line 347
    const-string v1, "android:support:next_request_index"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 348
    nop

    .line 349
    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Landroid/support/v4/app/k;->k:I

    .line 350
    const-string v1, "android:support:request_indicies"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getIntArray(Ljava/lang/String;)[I

    move-result-object v1

    .line 351
    .local v1, "requestCodes":[I
    const-string v3, "android:support:request_fragment_who"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getStringArray(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 352
    .local v3, "fragmentWhos":[Ljava/lang/String;
    if-eqz v1, :cond_3

    if-eqz v3, :cond_3

    array-length v4, v1

    array-length v5, v3

    if-eq v4, v5, :cond_2

    goto :goto_1

    .line 356
    :cond_2
    new-instance v4, La/b/c/f/n;

    array-length v5, v1

    invoke-direct {v4, v5}, La/b/c/f/n;-><init>(I)V

    iput-object v4, p0, Landroid/support/v4/app/k;->l:La/b/c/f/n;

    .line 357
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    array-length v5, v1

    if-ge v4, v5, :cond_4

    .line 358
    iget-object v5, p0, Landroid/support/v4/app/k;->l:La/b/c/f/n;

    aget v6, v1, v4

    aget-object v7, v3, v4

    invoke-virtual {v5, v6, v7}, La/b/c/f/n;->c(ILjava/lang/Object;)V

    .line 357
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 354
    .end local v4    # "i":I
    :cond_3
    :goto_1
    const-string v4, "FragmentActivity"

    const-string v5, "Invalid requestCode mapping in savedInstanceState."

    invoke-static {v4, v5}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 364
    .end local v1    # "requestCodes":[I
    .end local v2    # "p":Landroid/os/Parcelable;
    .end local v3    # "fragmentWhos":[Ljava/lang/String;
    :cond_4
    iget-object v1, p0, Landroid/support/v4/app/k;->l:La/b/c/f/n;

    if-nez v1, :cond_5

    .line 365
    new-instance v1, La/b/c/f/n;

    invoke-direct {v1}, La/b/c/f/n;-><init>()V

    iput-object v1, p0, Landroid/support/v4/app/k;->l:La/b/c/f/n;

    .line 366
    const/4 v1, 0x0

    iput v1, p0, Landroid/support/v4/app/k;->k:I

    .line 369
    :cond_5
    iget-object v1, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v1}, Landroid/support/v4/app/m;->b()V

    .line 370
    return-void
.end method

.method public onCreatePanelMenu(ILandroid/view/Menu;)Z
    .locals 3
    .param p1, "featureId"    # I
    .param p2, "menu"    # Landroid/view/Menu;

    .line 377
    if-nez p1, :cond_0

    .line 378
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onCreatePanelMenu(ILandroid/view/Menu;)Z

    move-result v0

    .line 379
    .local v0, "show":Z
    iget-object v1, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {p0}, Landroid/app/Activity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v2

    invoke-virtual {v1, p2, v2}, Landroid/support/v4/app/m;->a(Landroid/view/Menu;Landroid/view/MenuInflater;)Z

    move-result v1

    or-int/2addr v0, v1

    .line 380
    return v0

    .line 382
    .end local v0    # "show":Z
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onCreatePanelMenu(ILandroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method public onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 2
    .param p1, "parent"    # Landroid/view/View;
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "context"    # Landroid/content/Context;
    .param p4, "attrs"    # Landroid/util/AttributeSet;

    .line 387
    invoke-virtual {p0, p1, p2, p3, p4}, Landroid/support/v4/app/k;->a(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    .line 388
    .local v0, "v":Landroid/view/View;
    if-nez v0, :cond_0

    .line 389
    invoke-super {p0, p1, p2, p3, p4}, Landroid/app/Activity;->onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v1

    return-object v1

    .line 391
    :cond_0
    return-object v0
.end method

.method public onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "attrs"    # Landroid/util/AttributeSet;

    .line 396
    const/4 v0, 0x0

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/support/v4/app/k;->a(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    .line 397
    .local v0, "v":Landroid/view/View;
    if-nez v0, :cond_0

    .line 398
    invoke-super {p0, p1, p2, p3}, Landroid/app/Activity;->onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v1

    return-object v1

    .line 400
    :cond_0
    return-object v0
.end method

.method protected onDestroy()V
    .locals 1

    .line 413
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 415
    iget-object v0, p0, Landroid/support/v4/app/k;->e:Landroid/arch/lifecycle/s;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Landroid/app/Activity;->isChangingConfigurations()Z

    move-result v0

    if-nez v0, :cond_0

    .line 416
    iget-object v0, p0, Landroid/support/v4/app/k;->e:Landroid/arch/lifecycle/s;

    invoke-virtual {v0}, Landroid/arch/lifecycle/s;->a()V

    .line 419
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0}, Landroid/support/v4/app/m;->c()V

    .line 420
    return-void
.end method

.method public onLowMemory()V
    .locals 1

    .line 427
    invoke-super {p0}, Landroid/app/Activity;->onLowMemory()V

    .line 428
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0}, Landroid/support/v4/app/m;->d()V

    .line 429
    return-void
.end method

.method public onMenuItemSelected(ILandroid/view/MenuItem;)Z
    .locals 1
    .param p1, "featureId"    # I
    .param p2, "item"    # Landroid/view/MenuItem;

    .line 436
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onMenuItemSelected(ILandroid/view/MenuItem;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 437
    const/4 v0, 0x1

    return v0

    .line 440
    :cond_0
    if-eqz p1, :cond_2

    const/4 v0, 0x6

    if-eq p1, v0, :cond_1

    .line 448
    const/4 v0, 0x0

    return v0

    .line 445
    :cond_1
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0, p2}, Landroid/support/v4/app/m;->a(Landroid/view/MenuItem;)Z

    move-result v0

    return v0

    .line 442
    :cond_2
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0, p2}, Landroid/support/v4/app/m;->b(Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method public onMultiWindowModeChanged(Z)V
    .locals 1
    .param p1, "isInMultiWindowMode"    # Z

    .line 261
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/m;->a(Z)V

    .line 262
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .line 491
    invoke-super {p0, p1}, Landroid/app/Activity;->onNewIntent(Landroid/content/Intent;)V

    .line 492
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0}, Landroid/support/v4/app/m;->k()V

    .line 493
    return-void
.end method

.method public onPanelClosed(ILandroid/view/Menu;)V
    .locals 1
    .param p1, "featureId"    # I
    .param p2, "menu"    # Landroid/view/Menu;

    .line 457
    if-eqz p1, :cond_0

    goto :goto_0

    .line 459
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0, p2}, Landroid/support/v4/app/m;->a(Landroid/view/Menu;)V

    .line 462
    :goto_0
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onPanelClosed(ILandroid/view/Menu;)V

    .line 463
    return-void
.end method

.method protected onPause()V
    .locals 2

    .line 470
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 471
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/app/k;->g:Z

    .line 472
    iget-object v0, p0, Landroid/support/v4/app/k;->c:Landroid/os/Handler;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/os/Handler;->hasMessages(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 473
    iget-object v0, p0, Landroid/support/v4/app/k;->c:Landroid/os/Handler;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 474
    invoke-virtual {p0}, Landroid/support/v4/app/k;->e()V

    .line 476
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0}, Landroid/support/v4/app/m;->e()V

    .line 477
    return-void
.end method

.method public onPictureInPictureModeChanged(Z)V
    .locals 1
    .param p1, "isInPictureInPictureMode"    # Z

    .line 276
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/m;->b(Z)V

    .line 277
    return-void
.end method

.method protected onPostResume()V
    .locals 2

    .line 525
    invoke-super {p0}, Landroid/app/Activity;->onPostResume()V

    .line 526
    iget-object v0, p0, Landroid/support/v4/app/k;->c:Landroid/os/Handler;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 527
    invoke-virtual {p0}, Landroid/support/v4/app/k;->e()V

    .line 528
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0}, Landroid/support/v4/app/m;->i()Z

    .line 529
    return-void
.end method

.method public onPreparePanel(ILandroid/view/View;Landroid/view/Menu;)Z
    .locals 2
    .param p1, "featureId"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "menu"    # Landroid/view/Menu;

    .line 546
    if-nez p1, :cond_0

    if-eqz p3, :cond_0

    .line 547
    invoke-virtual {p0, p2, p3}, Landroid/support/v4/app/k;->a(Landroid/view/View;Landroid/view/Menu;)Z

    move-result v0

    .line 548
    .local v0, "goforit":Z
    iget-object v1, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v1, p3}, Landroid/support/v4/app/m;->b(Landroid/view/Menu;)Z

    move-result v1

    or-int/2addr v0, v1

    .line 549
    return v0

    .line 551
    .end local v0    # "goforit":Z
    :cond_0
    invoke-super {p0, p1, p2, p3}, Landroid/app/Activity;->onPreparePanel(ILandroid/view/View;Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method public onRequestPermissionsResult(I[Ljava/lang/String;[I)V
    .locals 6
    .param p1, "requestCode"    # I
    .param p2, "permissions"    # [Ljava/lang/String;
    .param p3, "grantResults"    # [I

    .line 845
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0}, Landroid/support/v4/app/m;->k()V

    .line 846
    shr-int/lit8 v0, p1, 0x10

    const v1, 0xffff

    and-int/2addr v0, v1

    .line 847
    .local v0, "index":I
    if-eqz v0, :cond_2

    .line 848
    add-int/lit8 v0, v0, -0x1

    .line 850
    iget-object v2, p0, Landroid/support/v4/app/k;->l:La/b/c/f/n;

    invoke-virtual {v2, v0}, La/b/c/f/n;->b(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 851
    .local v2, "who":Ljava/lang/String;
    iget-object v3, p0, Landroid/support/v4/app/k;->l:La/b/c/f/n;

    invoke-virtual {v3, v0}, La/b/c/f/n;->d(I)V

    .line 852
    const-string v3, "FragmentActivity"

    if-nez v2, :cond_0

    .line 853
    const-string v1, "Activity result delivered for unknown Fragment."

    invoke-static {v3, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 854
    return-void

    .line 856
    :cond_0
    iget-object v4, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v4, v2}, Landroid/support/v4/app/m;->a(Ljava/lang/String;)Landroid/support/v4/app/i;

    move-result-object v4

    .line 857
    .local v4, "frag":Landroid/support/v4/app/i;
    if-nez v4, :cond_1

    .line 858
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Activity result no fragment exists for who: "

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v3, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 860
    :cond_1
    and-int/2addr v1, p1

    invoke-virtual {v4, v1, p2, p3}, Landroid/support/v4/app/i;->a(I[Ljava/lang/String;[I)V

    .line 863
    .end local v2    # "who":Ljava/lang/String;
    .end local v4    # "frag":Landroid/support/v4/app/i;
    :cond_2
    :goto_0
    return-void
.end method

.method protected onResume()V
    .locals 2

    .line 514
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 515
    iget-object v0, p0, Landroid/support/v4/app/k;->c:Landroid/os/Handler;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 516
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/k;->g:Z

    .line 517
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0}, Landroid/support/v4/app/m;->i()Z

    .line 518
    return-void
.end method

.method public final onRetainNonConfigurationInstance()Ljava/lang/Object;
    .locals 4

    .line 569
    invoke-virtual {p0}, Landroid/support/v4/app/k;->f()Ljava/lang/Object;

    move-result-object v0

    .line 571
    .local v0, "custom":Ljava/lang/Object;
    iget-object v1, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v1}, Landroid/support/v4/app/m;->l()Landroid/support/v4/app/w;

    move-result-object v1

    .line 573
    .local v1, "fragments":Landroid/support/v4/app/w;
    if-nez v1, :cond_0

    iget-object v2, p0, Landroid/support/v4/app/k;->e:Landroid/arch/lifecycle/s;

    if-nez v2, :cond_0

    if-nez v0, :cond_0

    .line 574
    const/4 v2, 0x0

    return-object v2

    .line 577
    :cond_0
    new-instance v2, Landroid/support/v4/app/k$b;

    invoke-direct {v2}, Landroid/support/v4/app/k$b;-><init>()V

    .line 578
    .local v2, "nci":Landroid/support/v4/app/k$b;
    iput-object v0, v2, Landroid/support/v4/app/k$b;->a:Ljava/lang/Object;

    .line 579
    iget-object v3, p0, Landroid/support/v4/app/k;->e:Landroid/arch/lifecycle/s;

    iput-object v3, v2, Landroid/support/v4/app/k$b;->b:Landroid/arch/lifecycle/s;

    .line 580
    iput-object v1, v2, Landroid/support/v4/app/k$b;->c:Landroid/support/v4/app/w;

    .line 581
    return-object v2
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "outState"    # Landroid/os/Bundle;

    .line 589
    invoke-super {p0, p1}, Landroid/support/v4/app/X;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 590
    invoke-direct {p0}, Landroid/support/v4/app/k;->h()V

    .line 591
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0}, Landroid/support/v4/app/m;->m()Landroid/os/Parcelable;

    move-result-object v0

    .line 592
    .local v0, "p":Landroid/os/Parcelable;
    if-eqz v0, :cond_0

    .line 593
    const-string v1, "android:support:fragments"

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 595
    :cond_0
    iget-object v1, p0, Landroid/support/v4/app/k;->l:La/b/c/f/n;

    invoke-virtual {v1}, La/b/c/f/n;->b()I

    move-result v1

    if-lez v1, :cond_2

    .line 596
    iget v1, p0, Landroid/support/v4/app/k;->k:I

    const-string v2, "android:support:next_request_index"

    invoke-virtual {p1, v2, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 598
    iget-object v1, p0, Landroid/support/v4/app/k;->l:La/b/c/f/n;

    invoke-virtual {v1}, La/b/c/f/n;->b()I

    move-result v1

    new-array v1, v1, [I

    .line 599
    .local v1, "requestCodes":[I
    iget-object v2, p0, Landroid/support/v4/app/k;->l:La/b/c/f/n;

    invoke-virtual {v2}, La/b/c/f/n;->b()I

    move-result v2

    new-array v2, v2, [Ljava/lang/String;

    .line 600
    .local v2, "fragmentWhos":[Ljava/lang/String;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    iget-object v4, p0, Landroid/support/v4/app/k;->l:La/b/c/f/n;

    invoke-virtual {v4}, La/b/c/f/n;->b()I

    move-result v4

    if-ge v3, v4, :cond_1

    .line 601
    iget-object v4, p0, Landroid/support/v4/app/k;->l:La/b/c/f/n;

    invoke-virtual {v4, v3}, La/b/c/f/n;->c(I)I

    move-result v4

    aput v4, v1, v3

    .line 602
    iget-object v4, p0, Landroid/support/v4/app/k;->l:La/b/c/f/n;

    invoke-virtual {v4, v3}, La/b/c/f/n;->e(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    aput-object v4, v2, v3

    .line 600
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 604
    .end local v3    # "i":I
    :cond_1
    const-string v3, "android:support:request_indicies"

    invoke-virtual {p1, v3, v1}, Landroid/os/Bundle;->putIntArray(Ljava/lang/String;[I)V

    .line 605
    const-string v3, "android:support:request_fragment_who"

    invoke-virtual {p1, v3, v2}, Landroid/os/Bundle;->putStringArray(Ljava/lang/String;[Ljava/lang/String;)V

    .line 607
    .end local v1    # "requestCodes":[I
    .end local v2    # "fragmentWhos":[Ljava/lang/String;
    :cond_2
    return-void
.end method

.method protected onStart()V
    .locals 1

    .line 614
    invoke-super {p0}, Landroid/app/Activity;->onStart()V

    .line 616
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/app/k;->h:Z

    .line 618
    iget-boolean v0, p0, Landroid/support/v4/app/k;->f:Z

    if-nez v0, :cond_0

    .line 619
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/k;->f:Z

    .line 620
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0}, Landroid/support/v4/app/m;->a()V

    .line 623
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0}, Landroid/support/v4/app/m;->k()V

    .line 624
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0}, Landroid/support/v4/app/m;->i()Z

    .line 628
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0}, Landroid/support/v4/app/m;->g()V

    .line 629
    return-void
.end method

.method public onStateNotSaved()V
    .locals 1

    .line 500
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0}, Landroid/support/v4/app/m;->k()V

    .line 501
    return-void
.end method

.method protected onStop()V
    .locals 1

    .line 636
    invoke-super {p0}, Landroid/app/Activity;->onStop()V

    .line 638
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/k;->h:Z

    .line 639
    invoke-direct {p0}, Landroid/support/v4/app/k;->h()V

    .line 641
    iget-object v0, p0, Landroid/support/v4/app/k;->d:Landroid/support/v4/app/m;

    invoke-virtual {v0}, Landroid/support/v4/app/m;->h()V

    .line 642
    return-void
.end method

.method public startActivityForResult(Landroid/content/Intent;I)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "requestCode"    # I

    .line 749
    iget-boolean v0, p0, Landroid/support/v4/app/k;->j:Z

    if-nez v0, :cond_0

    .line 750
    const/4 v0, -0x1

    if-eq p2, v0, :cond_0

    .line 751
    invoke-static {p2}, Landroid/support/v4/app/k;->a(I)V

    .line 754
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 755
    return-void
.end method

.method public startActivityForResult(Landroid/content/Intent;ILandroid/os/Bundle;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "requestCode"    # I
    .param p3, "options"    # Landroid/os/Bundle;

    .line 762
    iget-boolean v0, p0, Landroid/support/v4/app/k;->j:Z

    if-nez v0, :cond_0

    .line 763
    const/4 v0, -0x1

    if-eq p2, v0, :cond_0

    .line 764
    invoke-static {p2}, Landroid/support/v4/app/k;->a(I)V

    .line 767
    :cond_0
    invoke-super {p0, p1, p2, p3}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;ILandroid/os/Bundle;)V

    .line 768
    return-void
.end method

.method public startIntentSenderForResult(Landroid/content/IntentSender;ILandroid/content/Intent;III)V
    .locals 1
    .param p1, "intent"    # Landroid/content/IntentSender;
    .param p2, "requestCode"    # I
    .param p3, "fillInIntent"    # Landroid/content/Intent;
    .param p4, "flagsMask"    # I
    .param p5, "flagsValues"    # I
    .param p6, "extraFlags"    # I

    .line 776
    iget-boolean v0, p0, Landroid/support/v4/app/k;->i:Z

    if-nez v0, :cond_0

    .line 777
    const/4 v0, -0x1

    if-eq p2, v0, :cond_0

    .line 778
    invoke-static {p2}, Landroid/support/v4/app/k;->a(I)V

    .line 781
    :cond_0
    invoke-super/range {p0 .. p6}, Landroid/app/Activity;->startIntentSenderForResult(Landroid/content/IntentSender;ILandroid/content/Intent;III)V

    .line 783
    return-void
.end method

.method public startIntentSenderForResult(Landroid/content/IntentSender;ILandroid/content/Intent;IIILandroid/os/Bundle;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/IntentSender;
    .param p2, "requestCode"    # I
    .param p3, "fillInIntent"    # Landroid/content/Intent;
    .param p4, "flagsMask"    # I
    .param p5, "flagsValues"    # I
    .param p6, "extraFlags"    # I
    .param p7, "options"    # Landroid/os/Bundle;

    .line 791
    iget-boolean v0, p0, Landroid/support/v4/app/k;->i:Z

    if-nez v0, :cond_0

    .line 792
    const/4 v0, -0x1

    if-eq p2, v0, :cond_0

    .line 793
    invoke-static {p2}, Landroid/support/v4/app/k;->a(I)V

    .line 796
    :cond_0
    invoke-super/range {p0 .. p7}, Landroid/app/Activity;->startIntentSenderForResult(Landroid/content/IntentSender;ILandroid/content/Intent;IIILandroid/os/Bundle;)V

    .line 798
    return-void
.end method
