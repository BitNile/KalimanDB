package org.bitnile.kalimandb.service.status;

import org.bitnile.kalimandb.common.document.Document;

public class CompositeResult {
    private DBOperationStatus status;
    private String msg;
    private int errCode;    // TODO(hecenjie): need to use Integer
    private Document[] documents;

    public CompositeResult(CompositeResultBuilder builder) {
        this.status = builder.status;
        this.msg = builder.msg;
        this.errCode = builder.errCode;
        this.documents = builder.documents;
    }

    public static CompositeResultBuilder builder() {
        return new CompositeResultBuilder();
    }

    public DBOperationStatus getStatus() {
        return status;
    }

    public void setStatus(DBOperationStatus status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public Document[] getDocuments() {
        return documents;
    }

    public void setDocuments(Document[] documents) {
        this.documents = documents;
    }

    public boolean isSuccess() {
        return status == DBOperationStatus.SUCCESS && errCode == 0;
    }

    public boolean isEmpty() {
        return documents == null || documents.length == 0;
    }

    public int size(){
        return documents == null ? 0 : documents.length;
    }

    public static class CompositeResultBuilder {

        private DBOperationStatus status;
        private String msg;
        private int errCode;
        private Document[] documents;

        public CompositeResultBuilder status(DBOperationStatus status) {
            this.status = status;
            return this;
        }

        public CompositeResultBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public CompositeResultBuilder errCode(int errCode) {
            this.errCode = errCode;
            return this;
        }

        public CompositeResultBuilder documents(Document[] documents) {
            this.documents = documents;
            return this;
        }

        public CompositeResult build() {
            return new CompositeResult(this);
        }
    }
}
