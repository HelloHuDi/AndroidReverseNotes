.class Landroid/support/v7/app/z;
.super Landroid/content/BroadcastReceiver;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/app/x$d;->d()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/app/x$d;


# direct methods
.method constructor <init>(Landroid/support/v7/app/x$d;)V
    .locals 0
    .param p1, "this$1"    # Landroid/support/v7/app/x$d;

    .line 2699
    iput-object p1, p0, Landroid/support/v7/app/z;->a:Landroid/support/v7/app/x$d;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .line 2705
    iget-object v0, p0, Landroid/support/v7/app/z;->a:Landroid/support/v7/app/x$d;

    invoke-virtual {v0}, Landroid/support/v7/app/x$d;->b()V

    .line 2706
    return-void
.end method
