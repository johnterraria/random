package com.filmkio.nativescreen.net;

import android.net.Uri;
import android.os.Build;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.filmkio.AppState;
import com.filmkio.MobileSessionInvalidation;
import com.google.android.gms.actions.SearchIntents;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.p007io.CloseableKt;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: FkApiClient.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m779d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001;B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0002J\b\u0010%\u001a\u00020\u0004H\u0002J\u0019\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010)J(\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0002J(\u0010/\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0002J*\u00100\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0015J`\u00101\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00152\u0014\b\u0002\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00152\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u00104\u001a\u00020\u001dJ\u001f\u00105\u001a\u0002062\u0006\u0010-\u001a\u00020\u00072\b\u00107\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0002\u00108J\u0010\u00109\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010:\u001a\u00020!2\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, m780d2 = {"Lcom/filmkio/nativescreen/net/FkApiClient;", "", "()V", "FK_APP_ID", "", "FK_APP_SECRET", "MAX_GET_ATTEMPTS", "", "MAX_MUTATION_ATTEMPTS", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "client$delegate", "Lkotlin/Lazy;", "rng", "Ljava/security/SecureRandom;", "buildUrl", "apiBase", "endpointPath", SearchIntents.EXTRA_QUERY, "", "buildUserAgent", "deriveRoutePrefix", "ensureSlashStart", CmcdData.Factory.STREAMING_FORMAT_SS, "hmacSha256Hex", "data", "isIdempotentMethod", "", FirebaseAnalytics.Param.METHOD, "isLikelyTlsIssue", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "", "joinPath", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "b", "makeNonce", "parseRetryAfterMillis", "", "value", "(Ljava/lang/String;)Ljava/lang/Long;", "shouldRetryHttpStatus", "code", "isIdempotent", "attempt", "maxAttempts", "shouldRetryThrowable", "signedGet", "signedRequest", "headers", "bodyJson", "trackSessionInvalidation", "sleepBeforeRetry", "", "retryAfterMillis", "(ILjava/lang/Long;)V", "trimSlashEnd", "unwrap", "ApiException", "app_mobileRelease"}, m781k = 1, m782mv = {1, 9, 0}, m784xi = 48)
public final class FkApiClient {
    private static final String FK_APP_ID = "filmkiotv";
    private static final String FK_APP_SECRET = "fkTv_8f1d7c96e4a24b1fb6c0e55a764ec9d1";
    private static final int MAX_GET_ATTEMPTS = 3;
    private static final int MAX_MUTATION_ATTEMPTS = 2;
    public static final FkApiClient INSTANCE = new FkApiClient();
    private static final SecureRandom rng = new SecureRandom();

    /* JADX INFO: renamed from: client$delegate, reason: from kotlin metadata */
    private static final Lazy client = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<OkHttpClient>() { // from class: com.filmkio.nativescreen.net.FkApiClient$client$2
        @Override // kotlin.jvm.functions.Function0
        public final OkHttpClient invoke() {
            FkNetworkCompat.INSTANCE.refreshSecurityProvider(false);
            return FkNetworkCompat.INSTANCE.apiClientBuilder().build();
        }
    });
    public static final int $stable = 8;

    private final boolean shouldRetryHttpStatus(int code, boolean isIdempotent, int attempt, int maxAttempts) {
        if (isIdempotent && attempt < maxAttempts) {
            return code == 408 || code == 425 || code == 429 || code == 500 || code == 502 || code == 503 || code == 504;
        }
        return false;
    }

    private FkApiClient() {
    }

    private final OkHttpClient getClient() {
        return (OkHttpClient) client.getValue();
    }

    /* JADX INFO: compiled from: FkApiClient.kt */
    @Metadata(m779d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m780d2 = {"Lcom/filmkio/nativescreen/net/FkApiClient$ApiException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "code", "", TtmlNode.TAG_BODY, "", "(ILjava/lang/String;)V", "getBody", "()Ljava/lang/String;", "getCode", "()I", "app_mobileRelease"}, m781k = 1, m782mv = {1, 9, 0}, m784xi = 48)
    public static final class ApiException extends RuntimeException {
        public static final int $stable = 0;
        private final String body;
        private final int code;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApiException(int i, String body) {
            super("HTTP_" + i);
            Intrinsics.checkNotNullParameter(body, "body");
            this.code = i;
            this.body = body;
        }

        public final String getBody() {
            return this.body;
        }

        public final int getCode() {
            return this.code;
        }
    }

    public final String signedGet(String apiBase, String endpointPath, Map<String, String> query) {
        Intrinsics.checkNotNullParameter(apiBase, "apiBase");
        Intrinsics.checkNotNullParameter(endpointPath, "endpointPath");
        Intrinsics.checkNotNullParameter(query, "query");
        return signedRequest$default(this, apiBase, endpointPath, "GET", query, null, null, false, 112, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String signedRequest$default(FkApiClient fkApiClient, String str, String str2, String str3, Map map, Map map2, String str4, boolean z, int i, Object obj) {
        return fkApiClient.signedRequest(str, str2, str3, (i & 8) != 0 ? MapsKt.emptyMap() : map, (i & 16) != 0 ? MapsKt.emptyMap() : map2, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? true : z);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ee A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e8 A[LOOP:0: B:9:0x004e->B:77:0x01e8, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String signedRequest(String apiBase, String endpointPath, String method, Map<String, String> query, Map<String, String> headers, String bodyJson, boolean trackSessionInvalidation) throws Throwable {
        Throwable th;
        RequestBody requestBodyCreate;
        Response responseExecute;
        Throwable th2;
        Response response;
        String apiBase2 = apiBase;
        Intrinsics.checkNotNullParameter(apiBase2, "apiBase");
        Intrinsics.checkNotNullParameter(endpointPath, "endpointPath");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(headers, "headers");
        String upperCase = method.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String strEnsureSlashStart = ensureSlashStart(endpointPath);
        String strJoinPath = joinPath(deriveRoutePrefix(apiBase), strEnsureSlashStart);
        boolean zIsIdempotentMethod = isIdempotentMethod(upperCase);
        int i = zIsIdempotentMethod ? 3 : 2;
        if (1 <= i) {
            int i2 = 1;
            Throwable th3 = null;
            while (true) {
                String strValueOf = String.valueOf(System.currentTimeMillis() / 1000);
                String strMakeNonce = makeNonce();
                Throwable th4 = th3;
                Request.Builder builderHeader = new Request.Builder().url(buildUrl(apiBase2, strEnsureSlashStart, query)).header("x-fk-app-id", FK_APP_ID).header("x-fk-ts", strValueOf).header("x-fk-nonce", strMakeNonce).header("x-fk-sign", hmacSha256Hex(upperCase + "\n" + strJoinPath + "\n" + strValueOf + "\n" + strMakeNonce)).header(HttpHeaders.USER_AGENT, buildUserAgent());
                String clientName = AppState.INSTANCE.getClientName();
                if (StringsKt.isBlank(clientName)) {
                    clientName = "FilmKioTV";
                }
                Request.Builder builderHeader2 = builderHeader.header("X-FilmKio-Client", clientName);
                String clientPlatform = AppState.INSTANCE.getClientPlatform();
                if (StringsKt.isBlank(clientPlatform)) {
                    clientPlatform = "tv";
                }
                Request.Builder builderHeader3 = builderHeader2.header("x-fk-platform", clientPlatform);
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    builderHeader3.header(entry.getKey(), entry.getValue());
                }
                String str = "";
                if (bodyJson != null) {
                    requestBodyCreate = RequestBody.INSTANCE.create(bodyJson, MediaType.INSTANCE.get("application/json; charset=utf-8"));
                } else {
                    requestBodyCreate = (Intrinsics.areEqual(upperCase, "GET") || Intrinsics.areEqual(upperCase, "HEAD")) ? null : RequestBody.INSTANCE.create("", MediaType.INSTANCE.get("application/json; charset=utf-8"));
                }
                try {
                    responseExecute = getClient().newCall(builderHeader3.method(upperCase, requestBodyCreate).build()).execute();
                    try {
                        response = responseExecute;
                        ResponseBody responseBodyBody = response.body();
                        if (responseBodyBody != null) {
                            try {
                                String strString = responseBodyBody.string();
                                if (strString != null) {
                                    str = strString;
                                }
                            } catch (Throwable th5) {
                                th2 = th5;
                                try {
                                    throw th2;
                                } catch (Throwable th6) {
                                    CloseableKt.closeFinally(responseExecute, th2);
                                    throw th6;
                                }
                            }
                        }
                        if (trackSessionInvalidation) {
                            MobileSessionInvalidation.INSTANCE.onApiResponse(response.code(), str, headers);
                        }
                    } catch (Throwable th7) {
                        th = th7;
                    }
                } catch (Throwable th8) {
                    th3 = th8;
                }
                if (response.isSuccessful()) {
                    CloseableKt.closeFinally(responseExecute, null);
                    return str;
                }
                FkApiClient fkApiClient = INSTANCE;
                if (fkApiClient.shouldRetryHttpStatus(response.code(), zIsIdempotentMethod, i2, i)) {
                    try {
                        Long retryAfterMillis = fkApiClient.parseRetryAfterMillis(Response.header$default(response, HttpHeaders.RETRY_AFTER, null, 2, null));
                        Unit unit = Unit.INSTANCE;
                        try {
                            CloseableKt.closeFinally(responseExecute, null);
                            sleepBeforeRetry(i2, retryAfterMillis);
                            th3 = th4;
                        } catch (Throwable th9) {
                            th3 = th9;
                        }
                        if (i2 != i) {
                            th = th3;
                            break;
                        }
                        i2++;
                        apiBase2 = apiBase;
                    } catch (Throwable th10) {
                        th = th10;
                        th2 = th;
                        throw th2;
                    }
                } else {
                    throw new ApiException(response.code(), StringsKt.take(str, 350));
                }
                th = th10;
                th2 = th;
                throw th2;
                if (isLikelyTlsIssue(th3)) {
                    FkNetworkCompat.INSTANCE.refreshSecurityProvider(false);
                }
                if (!shouldRetryThrowable(th3, zIsIdempotentMethod, i2, i)) {
                    throw th3;
                }
                sleepBeforeRetry(i2, null);
                if (i2 != i) {
                }
            }
        } else {
            th = null;
        }
        if (th == null) {
            throw new RuntimeException("NETWORK_RETRY_EXHAUSTED");
        }
        throw th;
    }

    private final boolean isIdempotentMethod(String method) {
        return Intrinsics.areEqual(method, "GET") || Intrinsics.areEqual(method, "HEAD") || Intrinsics.areEqual(method, "OPTIONS");
    }

    private final boolean shouldRetryThrowable(Throwable error, boolean isIdempotent, int attempt, int maxAttempts) {
        if (attempt >= maxAttempts) {
            return false;
        }
        Throwable thUnwrap = unwrap(error);
        if ((thUnwrap instanceof ApiException) || (thUnwrap instanceof InterruptedException)) {
            return false;
        }
        if ((thUnwrap instanceof UnknownHostException) || (thUnwrap instanceof ConnectException) || (thUnwrap instanceof SocketTimeoutException) || (thUnwrap instanceof SocketException) || (thUnwrap instanceof EOFException) || (thUnwrap instanceof SSLException)) {
            return true;
        }
        return isIdempotent && (thUnwrap instanceof IOException);
    }

    private final boolean isLikelyTlsIssue(Throwable error) {
        String lowerCase;
        Throwable thUnwrap = unwrap(error);
        if (thUnwrap instanceof SSLException) {
            return true;
        }
        String message = thUnwrap.getMessage();
        if (message != null) {
            lowerCase = message.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase == null) {
            lowerCase = "";
        }
        String str = lowerCase;
        return StringsKt.contains$default((CharSequence) str, (CharSequence) "ssl", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "tls", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "handshake", false, 2, (Object) null);
    }

    private final Long parseRetryAfterMillis(String value) {
        String string;
        Long longOrNull;
        if (value == null || (string = StringsKt.trim((CharSequence) value).toString()) == null || (longOrNull = StringsKt.toLongOrNull(string)) == null) {
            return null;
        }
        return Long.valueOf(RangesKt.coerceIn(longOrNull.longValue(), 0L, 8L) * 1000);
    }

    private final void sleepBeforeRetry(int attempt, Long retryAfterMillis) {
        long jMax = Math.max((attempt != 1 ? attempt != 2 ? 1800L : 900L : 350L) + Random.INSTANCE.nextLong(80L, 220L), retryAfterMillis != null ? retryAfterMillis.longValue() : 0L);
        if (jMax <= 0) {
            return;
        }
        try {
            Thread.sleep(jMax);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    private final Throwable unwrap(Throwable error) {
        for (int i = 0; error.getCause() != null && i < 8; i++) {
            error = error.getCause();
            Intrinsics.checkNotNull(error);
        }
        return error;
    }

    private final String buildUrl(String apiBase, String endpointPath, Map<String, String> query) {
        Uri.Builder builderBuildUpon = Uri.parse(trimSlashEnd(apiBase) + ensureSlashStart(endpointPath)).buildUpon();
        for (Map.Entry<String, String> entry : query.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!StringsKt.isBlank(value)) {
                builderBuildUpon.appendQueryParameter(key, value);
            }
        }
        String string = builderBuildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final String deriveRoutePrefix(String apiBase) {
        String path = new URL(apiBase).getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        String strTrimSlashEnd = trimSlashEnd(path);
        if (StringsKt.startsWith$default(strTrimSlashEnd, "/wp-json", false, 2, (Object) null)) {
            strTrimSlashEnd = StringsKt.removePrefix(strTrimSlashEnd, (CharSequence) "/wp-json");
        }
        return trimSlashEnd(ensureSlashStart(strTrimSlashEnd));
    }

    private final String buildUserAgent() {
        String str = "0";
        String clientName = AppState.INSTANCE.getClientName();
        if (StringsKt.isBlank(clientName)) {
            clientName = "FilmKioTV";
        }
        String str2 = clientName;
        try {
            Object obj = Class.forName("com.filmkio.BuildConfig").getDeclaredField("VERSION_NAME").get(null);
            String str3 = obj instanceof String ? (String) obj : null;
            if (str3 != null) {
                str = str3;
            }
        } catch (Throwable unused) {
        }
        int i = Build.VERSION.SDK_INT;
        String str4 = Build.VERSION.RELEASE;
        if (str4 == null) {
            str4 = "Android";
        }
        return str2 + "/" + str + " (Android " + str4 + "; SDK " + i + "; " + StringsKt.trim((CharSequence) (Build.MANUFACTURER + " " + Build.MODEL)).toString() + ")";
    }

    private final String joinPath(String a, String b) {
        return trimSlashEnd(a) + ensureSlashStart(b);
    }

    private final String ensureSlashStart(String s) {
        return StringsKt.startsWith$default(s, "/", false, 2, (Object) null) ? s : "/" + s;
    }

    private final String trimSlashEnd(String s) {
        return new Regex("/+$").replace(s, "");
    }

    private final String makeNonce() {
        byte[] bArr = new byte[12];
        rng.nextBytes(bArr);
        StringBuilder sb = new StringBuilder(24);
        for (int i = 0; i < 12; i++) {
            byte b = bArr[i];
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            sb.append(str);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final String hmacSha256Hex(String data) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        byte[] bytes = FK_APP_SECRET.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        mac.init(new SecretKeySpec(bytes, "HmacSHA256"));
        byte[] bytes2 = data.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        byte[] bArrDoFinal = mac.doFinal(bytes2);
        StringBuilder sb = new StringBuilder(bArrDoFinal.length * 2);
        Intrinsics.checkNotNull(bArrDoFinal);
        for (byte b : bArrDoFinal) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            sb.append(str);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
