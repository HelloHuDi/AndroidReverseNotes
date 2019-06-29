.class final Landroid/support/v4/app/c$a;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/app/c;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "a"
.end annotation


# instance fields
.field a:I

.field b:Landroid/support/v4/app/i;

.field c:I

.field d:I

.field e:I

.field f:I


# direct methods
.method constructor <init>()V
    .locals 0

    .line 200
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 201
    return-void
.end method

.method constructor <init>(ILandroid/support/v4/app/i;)V
    .locals 0
    .param p1, "cmd"    # I
    .param p2, "fragment"    # Landroid/support/v4/app/i;

    .line 203
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 204
    iput p1, p0, Landroid/support/v4/app/c$a;->a:I

    .line 205
    iput-object p2, p0, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    .line 206
    return-void
.end method
