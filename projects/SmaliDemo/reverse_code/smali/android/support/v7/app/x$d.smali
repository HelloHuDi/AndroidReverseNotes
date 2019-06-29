.class final Landroid/support/v7/app/x$d;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/app/x;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "d"
.end annotation


# instance fields
.field private a:Landroid/support/v7/app/E;

.field private b:Z

.field private c:Landroid/content/BroadcastReceiver;

.field private d:Landroid/content/IntentFilter;

.field final synthetic e:Landroid/support/v7/app/x;


# direct methods
.method constructor <init>(Landroid/support/v7/app/x;Landroid/support/v7/app/E;)V
    .locals 1
    .param p1, "this$0"    # Landroid/support/v7/app/x;
    .param p2, "twilightManager"    # Landroid/support/v7/app/E;

    .line 2673
    iput-object p1, p0, Landroid/support/v7/app/x$d;->e:Landroid/support/v7/app/x;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2674
    iput-object p2, p0, Landroid/support/v7/app/x$d;->a:Landroid/support/v7/app/E;

    .line 2675
    invoke-virtual {p2}, Landroid/support/v7/app/E;->a()Z

    move-result v0

    iput-boolean v0, p0, Landroid/support/v7/app/x$d;->b:Z

    .line 2676
    return-void
.end method


# virtual methods
.method a()V
    .locals 2

    .line 2719
    iget-object v0, p0, Landroid/support/v7/app/x$d;->c:Landroid/content/BroadcastReceiver;

    if-eqz v0, :cond_0

    .line 2720
    iget-object v1, p0, Landroid/support/v7/app/x$d;->e:Landroid/support/v7/app/x;

    iget-object v1, v1, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 2721
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v7/app/x$d;->c:Landroid/content/BroadcastReceiver;

    .line 2723
    :cond_0
    return-void
.end method

.method b()V
    .locals 2

    .line 2685
    iget-object v0, p0, Landroid/support/v7/app/x$d;->a:Landroid/support/v7/app/E;

    invoke-virtual {v0}, Landroid/support/v7/app/E;->a()Z

    move-result v0

    .line 2686
    .local v0, "isNight":Z
    iget-boolean v1, p0, Landroid/support/v7/app/x$d;->b:Z

    if-eq v0, v1, :cond_0

    .line 2687
    iput-boolean v0, p0, Landroid/support/v7/app/x$d;->b:Z

    .line 2688
    iget-object v1, p0, Landroid/support/v7/app/x$d;->e:Landroid/support/v7/app/x;

    invoke-virtual {v1}, Landroid/support/v7/app/x;->a()Z

    .line 2690
    :cond_0
    return-void
.end method

.method c()I
    .locals 1

    .line 2680
    iget-object v0, p0, Landroid/support/v7/app/x$d;->a:Landroid/support/v7/app/E;

    invoke-virtual {v0}, Landroid/support/v7/app/E;->a()Z

    move-result v0

    iput-boolean v0, p0, Landroid/support/v7/app/x$d;->b:Z

    .line 2681
    iget-boolean v0, p0, Landroid/support/v7/app/x$d;->b:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x2

    goto :goto_0

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0
.end method

.method d()V
    .locals 3

    .line 2693
    invoke-virtual {p0}, Landroid/support/v7/app/x$d;->a()V

    .line 2698
    iget-object v0, p0, Landroid/support/v7/app/x$d;->c:Landroid/content/BroadcastReceiver;

    if-nez v0, :cond_0

    .line 2699
    new-instance v0, Landroid/support/v7/app/z;

    invoke-direct {v0, p0}, Landroid/support/v7/app/z;-><init>(Landroid/support/v7/app/x$d;)V

    iput-object v0, p0, Landroid/support/v7/app/x$d;->c:Landroid/content/BroadcastReceiver;

    .line 2709
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/x$d;->d:Landroid/content/IntentFilter;

    if-nez v0, :cond_1

    .line 2710
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    iput-object v0, p0, Landroid/support/v7/app/x$d;->d:Landroid/content/IntentFilter;

    .line 2711
    iget-object v0, p0, Landroid/support/v7/app/x$d;->d:Landroid/content/IntentFilter;

    const-string v1, "android.intent.action.TIME_SET"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 2712
    iget-object v0, p0, Landroid/support/v7/app/x$d;->d:Landroid/content/IntentFilter;

    const-string v1, "android.intent.action.TIMEZONE_CHANGED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 2713
    iget-object v0, p0, Landroid/support/v7/app/x$d;->d:Landroid/content/IntentFilter;

    const-string v1, "android.intent.action.TIME_TICK"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 2715
    :cond_1
    iget-object v0, p0, Landroid/support/v7/app/x$d;->e:Landroid/support/v7/app/x;

    iget-object v0, v0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    iget-object v1, p0, Landroid/support/v7/app/x$d;->c:Landroid/content/BroadcastReceiver;

    iget-object v2, p0, Landroid/support/v7/app/x$d;->d:Landroid/content/IntentFilter;

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 2716
    return-void
.end method
