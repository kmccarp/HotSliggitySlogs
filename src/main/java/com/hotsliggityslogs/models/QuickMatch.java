package com.hotsliggityslogs.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "quickmatch")
public class QuickMatch extends Match {}
