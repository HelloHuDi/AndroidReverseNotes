.class La/b/c/d/i;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = La/b/c/d/k;->a(Ljava/util/concurrent/Callable;La/b/c/d/k$a;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/util/concurrent/Callable;

.field final synthetic b:Landroid/os/Handler;

.field final synthetic c:La/b/c/d/k$a;

.field final synthetic d:La/b/c/d/k;


# direct methods
.method constructor <init>(La/b/c/d/k;Ljava/util/concurrent/Callable;Landroid/os/Handler;La/b/c/d/k$a;)V
    .locals 0
    .param p1, "this$0"    # La/b/c/d/k;

    .line 137
    iput-object p1, p0, La/b/c/d/i;->d:La/b/c/d/k;

    iput-object p2, p0, La/b/c/d/i;->a:Ljava/util/concurrent/Callable;

    iput-object p3, p0, La/b/c/d/i;->b:Landroid/os/Handler;

    iput-object p4, p0, La/b/c/d/i;->c:La/b/c/d/k$a;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .line 142
    :try_start_0
    iget-object v0, p0, La/b/c/d/i;->a:Ljava/util/concurrent/Callable;

    invoke-interface {v0}, Ljava/util/concurrent/Callable;->call()Ljava/lang/Object;

    move-result-object v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 145
    .local v0, "t":Ljava/lang/Object;, "TT;"
    goto :goto_0

    .line 143
    .end local v0    # "t":Ljava/lang/Object;, "TT;"
    :catch_0
    move-exception v0

    .line 144
    .local v0, "e":Ljava/lang/Exception;
    const/4 v0, 0x0

    .line 146
    .local v0, "t":Ljava/lang/Object;, "TT;"
    :goto_0
    move-object v1, v0

    .line 147
    .local v1, "result":Ljava/lang/Object;, "TT;"
    iget-object v2, p0, La/b/c/d/i;->b:Landroid/os/Handler;

    new-instance v3, La/b/c/d/h;

    invoke-direct {v3, p0, v1}, La/b/c/d/h;-><init>(La/b/c/d/i;Ljava/lang/Object;)V

    invoke-virtual {v2, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 153
    return-void
.end method
