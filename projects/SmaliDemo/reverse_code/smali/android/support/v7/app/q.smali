.class Landroid/support/v7/app/q;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/app/x;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/app/x;


# direct methods
.method constructor <init>(Landroid/support/v7/app/x;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/app/x;

    .line 223
    iput-object p1, p0, Landroid/support/v7/app/q;->a:Landroid/support/v7/app/x;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .line 226
    iget-object v0, p0, Landroid/support/v7/app/q;->a:Landroid/support/v7/app/x;

    iget v1, v0, Landroid/support/v7/app/x;->P:I

    and-int/lit8 v1, v1, 0x1

    const/4 v2, 0x0

    if-eqz v1, :cond_0

    .line 227
    invoke-virtual {v0, v2}, Landroid/support/v7/app/x;->e(I)V

    .line 229
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/q;->a:Landroid/support/v7/app/x;

    iget v1, v0, Landroid/support/v7/app/x;->P:I

    and-int/lit16 v1, v1, 0x1000

    if-eqz v1, :cond_1

    .line 230
    const/16 v1, 0x6c

    invoke-virtual {v0, v1}, Landroid/support/v7/app/x;->e(I)V

    .line 232
    :cond_1
    iget-object v0, p0, Landroid/support/v7/app/q;->a:Landroid/support/v7/app/x;

    iput-boolean v2, v0, Landroid/support/v7/app/x;->O:Z

    .line 233
    iput v2, v0, Landroid/support/v7/app/x;->P:I

    .line 234
    return-void
.end method
