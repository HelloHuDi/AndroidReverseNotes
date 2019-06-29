.class Landroid/support/v7/app/c;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/app/AlertController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/app/AlertController;


# direct methods
.method constructor <init>(Landroid/support/v7/app/AlertController;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/app/AlertController;

    .line 126
    iput-object p1, p0, Landroid/support/v7/app/c;->a:Landroid/support/v7/app/AlertController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .line 130
    iget-object v0, p0, Landroid/support/v7/app/c;->a:Landroid/support/v7/app/AlertController;

    iget-object v1, v0, Landroid/support/v7/app/AlertController;->o:Landroid/widget/Button;

    if-ne p1, v1, :cond_0

    iget-object v0, v0, Landroid/support/v7/app/AlertController;->q:Landroid/os/Message;

    if-eqz v0, :cond_0

    .line 131
    invoke-static {v0}, Landroid/os/Message;->obtain(Landroid/os/Message;)Landroid/os/Message;

    move-result-object v0

    .local v0, "m":Landroid/os/Message;
    goto :goto_0

    .line 132
    .end local v0    # "m":Landroid/os/Message;
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/c;->a:Landroid/support/v7/app/AlertController;

    iget-object v1, v0, Landroid/support/v7/app/AlertController;->s:Landroid/widget/Button;

    if-ne p1, v1, :cond_1

    iget-object v0, v0, Landroid/support/v7/app/AlertController;->u:Landroid/os/Message;

    if-eqz v0, :cond_1

    .line 133
    invoke-static {v0}, Landroid/os/Message;->obtain(Landroid/os/Message;)Landroid/os/Message;

    move-result-object v0

    .restart local v0    # "m":Landroid/os/Message;
    goto :goto_0

    .line 134
    .end local v0    # "m":Landroid/os/Message;
    :cond_1
    iget-object v0, p0, Landroid/support/v7/app/c;->a:Landroid/support/v7/app/AlertController;

    iget-object v1, v0, Landroid/support/v7/app/AlertController;->w:Landroid/widget/Button;

    if-ne p1, v1, :cond_2

    iget-object v0, v0, Landroid/support/v7/app/AlertController;->y:Landroid/os/Message;

    if-eqz v0, :cond_2

    .line 135
    invoke-static {v0}, Landroid/os/Message;->obtain(Landroid/os/Message;)Landroid/os/Message;

    move-result-object v0

    .restart local v0    # "m":Landroid/os/Message;
    goto :goto_0

    .line 137
    .end local v0    # "m":Landroid/os/Message;
    :cond_2
    const/4 v0, 0x0

    .line 140
    .restart local v0    # "m":Landroid/os/Message;
    :goto_0
    if-eqz v0, :cond_3

    .line 141
    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 145
    :cond_3
    iget-object v1, p0, Landroid/support/v7/app/c;->a:Landroid/support/v7/app/AlertController;

    iget-object v2, v1, Landroid/support/v7/app/AlertController;->R:Landroid/os/Handler;

    const/4 v3, 0x1

    iget-object v1, v1, Landroid/support/v7/app/AlertController;->b:Landroid/support/v7/app/B;

    invoke-virtual {v2, v3, v1}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    .line 146
    invoke-virtual {v1}, Landroid/os/Message;->sendToTarget()V

    .line 147
    return-void
.end method
