.class public Landroid/arch/lifecycle/p;
.super Landroid/app/Fragment;
.source ""


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/arch/lifecycle/p$a;
    }
.end annotation


# instance fields
.field private a:Landroid/arch/lifecycle/p$a;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 130
    return-void
.end method

.method public static a(Landroid/app/Activity;)V
    .locals 4
    .param p0, "activity"    # Landroid/app/Activity;

    .line 37
    invoke-virtual {p0}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 38
    .local v0, "manager":Landroid/app/FragmentManager;
    const-string v1, "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag"

    invoke-virtual {v0, v1}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v2

    if-nez v2, :cond_0

    .line 39
    invoke-virtual {v0}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v2

    new-instance v3, Landroid/arch/lifecycle/p;

    invoke-direct {v3}, Landroid/arch/lifecycle/p;-><init>()V

    invoke-virtual {v2, v3, v1}, Landroid/app/FragmentTransaction;->add(Landroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    .line 41
    invoke-virtual {v0}, Landroid/app/FragmentManager;->executePendingTransactions()Z

    .line 43
    :cond_0
    return-void
.end method

.method private a(Landroid/arch/lifecycle/d$a;)V
    .locals 3
    .param p1, "event"    # Landroid/arch/lifecycle/d$a;

    .line 112
    invoke-virtual {p0}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 113
    .local v0, "activity":Landroid/app/Activity;
    instance-of v1, v0, Landroid/arch/lifecycle/i;

    if-eqz v1, :cond_0

    .line 114
    move-object v1, v0

    check-cast v1, Landroid/arch/lifecycle/i;

    invoke-interface {v1}, Landroid/arch/lifecycle/i;->a()Landroid/arch/lifecycle/h;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroid/arch/lifecycle/h;->b(Landroid/arch/lifecycle/d$a;)V

    .line 115
    return-void

    .line 118
    :cond_0
    instance-of v1, v0, Landroid/arch/lifecycle/f;

    if-eqz v1, :cond_1

    .line 119
    move-object v1, v0

    check-cast v1, Landroid/arch/lifecycle/f;

    invoke-interface {v1}, Landroid/arch/lifecycle/f;->a()Landroid/arch/lifecycle/d;

    move-result-object v1

    .line 120
    .local v1, "lifecycle":Landroid/arch/lifecycle/d;
    instance-of v2, v1, Landroid/arch/lifecycle/h;

    if-eqz v2, :cond_1

    .line 121
    move-object v2, v1

    check-cast v2, Landroid/arch/lifecycle/h;

    invoke-virtual {v2, p1}, Landroid/arch/lifecycle/h;->b(Landroid/arch/lifecycle/d$a;)V

    .line 124
    .end local v1    # "lifecycle":Landroid/arch/lifecycle/d;
    :cond_1
    return-void
.end method

.method private a(Landroid/arch/lifecycle/p$a;)V
    .locals 0
    .param p1, "listener"    # Landroid/arch/lifecycle/p$a;

    .line 53
    if-eqz p1, :cond_0

    .line 54
    invoke-interface {p1}, Landroid/arch/lifecycle/p$a;->onCreate()V

    .line 56
    :cond_0
    return-void
.end method

.method private b(Landroid/arch/lifecycle/p$a;)V
    .locals 0
    .param p1, "listener"    # Landroid/arch/lifecycle/p$a;

    .line 65
    if-eqz p1, :cond_0

    .line 66
    invoke-interface {p1}, Landroid/arch/lifecycle/p$a;->a()V

    .line 68
    :cond_0
    return-void
.end method

.method private c(Landroid/arch/lifecycle/p$a;)V
    .locals 0
    .param p1, "listener"    # Landroid/arch/lifecycle/p$a;

    .line 59
    if-eqz p1, :cond_0

    .line 60
    invoke-interface {p1}, Landroid/arch/lifecycle/p$a;->b()V

    .line 62
    :cond_0
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 72
    invoke-super {p0, p1}, Landroid/app/Fragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 73
    iget-object v0, p0, Landroid/arch/lifecycle/p;->a:Landroid/arch/lifecycle/p$a;

    invoke-direct {p0, v0}, Landroid/arch/lifecycle/p;->a(Landroid/arch/lifecycle/p$a;)V

    .line 74
    sget-object v0, Landroid/arch/lifecycle/d$a;->ON_CREATE:Landroid/arch/lifecycle/d$a;

    invoke-direct {p0, v0}, Landroid/arch/lifecycle/p;->a(Landroid/arch/lifecycle/d$a;)V

    .line 75
    return-void
.end method

.method public onDestroy()V
    .locals 1

    .line 105
    invoke-super {p0}, Landroid/app/Fragment;->onDestroy()V

    .line 106
    sget-object v0, Landroid/arch/lifecycle/d$a;->ON_DESTROY:Landroid/arch/lifecycle/d$a;

    invoke-direct {p0, v0}, Landroid/arch/lifecycle/p;->a(Landroid/arch/lifecycle/d$a;)V

    .line 108
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/arch/lifecycle/p;->a:Landroid/arch/lifecycle/p$a;

    .line 109
    return-void
.end method

.method public onPause()V
    .locals 1

    .line 93
    invoke-super {p0}, Landroid/app/Fragment;->onPause()V

    .line 94
    sget-object v0, Landroid/arch/lifecycle/d$a;->ON_PAUSE:Landroid/arch/lifecycle/d$a;

    invoke-direct {p0, v0}, Landroid/arch/lifecycle/p;->a(Landroid/arch/lifecycle/d$a;)V

    .line 95
    return-void
.end method

.method public onResume()V
    .locals 1

    .line 86
    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    .line 87
    iget-object v0, p0, Landroid/arch/lifecycle/p;->a:Landroid/arch/lifecycle/p$a;

    invoke-direct {p0, v0}, Landroid/arch/lifecycle/p;->b(Landroid/arch/lifecycle/p$a;)V

    .line 88
    sget-object v0, Landroid/arch/lifecycle/d$a;->ON_RESUME:Landroid/arch/lifecycle/d$a;

    invoke-direct {p0, v0}, Landroid/arch/lifecycle/p;->a(Landroid/arch/lifecycle/d$a;)V

    .line 89
    return-void
.end method

.method public onStart()V
    .locals 1

    .line 79
    invoke-super {p0}, Landroid/app/Fragment;->onStart()V

    .line 80
    iget-object v0, p0, Landroid/arch/lifecycle/p;->a:Landroid/arch/lifecycle/p$a;

    invoke-direct {p0, v0}, Landroid/arch/lifecycle/p;->c(Landroid/arch/lifecycle/p$a;)V

    .line 81
    sget-object v0, Landroid/arch/lifecycle/d$a;->ON_START:Landroid/arch/lifecycle/d$a;

    invoke-direct {p0, v0}, Landroid/arch/lifecycle/p;->a(Landroid/arch/lifecycle/d$a;)V

    .line 82
    return-void
.end method

.method public onStop()V
    .locals 1

    .line 99
    invoke-super {p0}, Landroid/app/Fragment;->onStop()V

    .line 100
    sget-object v0, Landroid/arch/lifecycle/d$a;->ON_STOP:Landroid/arch/lifecycle/d$a;

    invoke-direct {p0, v0}, Landroid/arch/lifecycle/p;->a(Landroid/arch/lifecycle/d$a;)V

    .line 101
    return-void
.end method
