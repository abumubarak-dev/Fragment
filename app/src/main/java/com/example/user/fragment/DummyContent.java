package com.example.user.fragment;

public class DummyContent {

        public final String id;
        public final String content;
        public final String details;

        public DummyContent(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }


        public String getId() {
            return id;
        }

        public String getContent() {
            return content;
        }

        public String getDetails() {
            return details;
        }

}
