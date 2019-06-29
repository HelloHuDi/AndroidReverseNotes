.class La/b/c/d/h;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = La/b/c/d/i;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/Object;

.field final synthetic b:La/b/c/d/i;


# direct methods
.method constructor <init>(La/b/c/d/i;Ljava/lang/Object;)V
    .locals 0
    .param p1, "this$1"    # La/b/c/d/i;

    .line 147
    iput-object p1, p0, La/b/c/d/h;->b:La/b/c/d/i;

    iput-object p2, p0, La/b/c/d/h;->a:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .line 150
    iget-object v0, p0, La/b/c/d/h;->b:La/b/c/d/i;

    iget-object v0, v0, La/b/c/d/i;->c:La/b/c/d/k$a;

    iget-object v1, p0, La/b/c/d/h;->a:Ljava/lang/Object;

    invoke-interface {v0, v1}, La/b/c/d/k$a;->a(Ljava/lang/Object;)V

    .line 151
    return-void
.end method
