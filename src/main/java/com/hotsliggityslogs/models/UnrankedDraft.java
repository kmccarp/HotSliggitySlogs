package com.hotsliggityslogs.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "unrankeddraft")
public class UnrankedDraft extends Match {}
