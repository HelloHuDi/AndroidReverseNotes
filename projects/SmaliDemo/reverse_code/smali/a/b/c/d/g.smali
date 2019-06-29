.class La/b/c/d/g;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/os/Handler$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/c/d/k;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:La/b/c/d/k;


# direct methods
.method constructor <init>(La/b/c/d/k;)V
    .locals 0
    .param p1, "this$0"    # La/b/c/d/k;

    .line 58
    iput-object p1, p0, La/b/c/d/g;->a:La/b/c/d/k;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)Z
    .locals 3
    .param p1, "msg"    # Landroid/os/Message;

    .line 61
    iget v0, p1, Landroid/os/Message;->what:I

    const/4 v1, 0x1

    if-eqz v0, :cond_1

    if-eq v0, v1, :cond_0

    .line 69
    return v1

    .line 63
    :cond_0
    iget-object v0, p0, La/b/c/d/g;->a:La/b/c/d/k;

    iget-object v2, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v2, Ljava/lang/Runnable;

    invoke-virtual {v0, v2}, La/b/c/d/k;->a(Ljava/lang/Runnable;)V

    .line 64
    return v1

    .line 66
    :cond_1
    iget-object v0, p0, La/b/c/d/g;->a:La/b/c/d/k;

    invoke-virtual {v0}, La/b/c/d/k;->a()V

    .line 67
    return v1
.end method
