package config;

import com.sun.istack.Nullable;

public class ServerResponseAfterAuthorization {

        @Nullable
        private String success;
        private String accessToken;
        private String refreshToken;
        //private String user;

        public String getSuccess() {
            return success;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setSuccess(String success) {
            this.success = success;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }
}
