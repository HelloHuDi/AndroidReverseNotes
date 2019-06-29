.class La/b/c/a/a/g;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = La/b/c/a/a/h$a;->a(ILandroid/os/Handler;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:I

.field final synthetic b:La/b/c/a/a/h$a;


# direct methods
.method constructor <init>(La/b/c/a/a/h$a;I)V
    .locals 0
    .param p1, "this$0"    # La/b/c/a/a/h$a;

    .line 266
    iput-object p1, p0, La/b/c/a/a/g;->b:La/b/c/a/a/h$a;

    iput p2, p0, La/b/c/a/a/g;->a:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .line 269
    iget-object v0, p0, La/b/c/a/a/g;->b:La/b/c/a/a/h$a;

    iget v1, p0, La/b/c/a/a/g;->a:I

    invoke-virtual {v0, v1}, La/b/c/a/a/h$a;->a(I)V

    .line 270
    return-void
.end method
